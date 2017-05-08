package net.jcip.robin_test;

/**
 * Created by robin on 2017/5/8.
 */
public class reentrant {
    public synchronized void dosomething(){
        System.out.println("dosomething");
        dosomething();
    }
    public static void main(String[] args){
        new reentrant().dosomething();
    }
}
