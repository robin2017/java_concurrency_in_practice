package net.jcip.robin_test;

import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * Created by robin on 2017/5/13.
 */
public class Recursive {

    //串行迭代
    public<T> void sequentialRecursive(List<Node<T>> nodes,Collection<T> results){
        for(Node<T> n:nodes){
            results.add(n.compute());
            sequentialRecursive(n.getChildren(), (Collection<Object>) results);
        }
    }

    //并行迭代
    public<T> void parallelRecursive(final Executor executor,List<Node<T>> nodes, final Collection<T> results){
        for(final Node<T> n:nodes){
            executor.execute(new Runnable(){
                @Override
                public void run() {
                    results.add(n.compute());
                }
            });
            parallelRecursive(executor,n.getChildren(), (Collection<Object>) results);
        }
    }
    //并行迭代的结果还需要等待获得
    public<T> Collection<T> getParallelResults(List<Node<T>> nodes) throws InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        Queue<T> resultQueue=new ConcurrentLinkedQueue<T>();
        parallelRecursive(executorService,nodes,resultQueue);
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        return resultQueue;
    }
}


class Node<T>{
    public T compute() {
        return null;
    }

    public <T> List<Node<T>> getChildren() {
        return null;
    }
}