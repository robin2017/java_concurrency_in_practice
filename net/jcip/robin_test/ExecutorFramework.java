package net.jcip.robin_test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by robin on 2017/5/11.
 */
public class ExecutorFramework {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final String[] in=null;
        ExecutorService executorService= Executors.newCachedThreadPool();
        //completionservice封装了executor和blockingqueue
        CompletionService<String> completionService=new ExecutorCompletionService<String>(executorService);
        //n个任务分配n个线程
        for(final String i:in){
            completionService.submit(new Callable<String>() { //n个生产者线程，产品放到completionservice里面的阻塞队列中
                @Override
                public String call() throws Exception {
                    return handle(i);
                }
            });
        }
        List<String> result=new ArrayList<String>();
        for(int i=0;i<in.length;i++){
            Future<String> future=completionService.take(); //消费者从阻塞队列中取得产品
            result.add(future.get());
        }
    }

//    public static void main(String[] args){
//        Executor executor= Executors.newSingleThreadExecutor();
//        Runnable runnable=new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        };
//        executor.execute(runnable);
//    }

    private static String handle(String i){
        return null;
    }


//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService= Executors.newCachedThreadPool();
//        Callable<String> callable=new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return null;
//            }
//        };
//        Future<String> future=executorService.submit(callable);
//        String result=future.get();
//    }
}
