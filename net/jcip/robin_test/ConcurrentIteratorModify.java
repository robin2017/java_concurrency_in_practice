package net.jcip.robin_test;

/**
 * Created by robin on 2017/5/9.
 */

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentIteratorModify {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<String>();
        list.add("t1");
        list.add("t2");
        list.add("t3");
        list.add("t4");
        list.add("t5");
        Thread thread1 = new Thread(new IteratorMap(list));
        Iterator it1 = list.iterator();
        thread1.start();
        for (;it1.hasNext();) {
            System.out.println(it1.next());
        }
        Thread thread2 = new Thread(new IteratorMap(list));
        Iterator it2 = list.iterator();
        thread2.start();
        for (;it2.hasNext();) {
            System.out.println(it2.next());
        }
    }
}
class IteratorMap implements Runnable{
    CopyOnWriteArrayList<String> list ;
    public IteratorMap(CopyOnWriteArrayList<String> list){
        this.list = list;
    }
    public void run() {
        list.add("t6");
    }
}


//public class ConcurrentIteratorModify {
//
//    public static void main(String[] args) {
//        ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<String, String>();
//        hashMap.put("t1","test1");
//        hashMap.put("t2","test2");
//        hashMap.put("t3","test3");
//        hashMap.put("t4","test4");
//
//        IteratorMap itMap = new IteratorMap(hashMap);
//        Thread thread = new Thread(itMap);
//
//        Collection<String> valus = hashMap.values();
//        Iterator it = valus.iterator();
//        thread.start();
//        for (;it.hasNext();) {
//            System.out.println(it.next());
//        }
//    }
//}
//class IteratorMap implements Runnable{
//    ConcurrentHashMap<String, String> hashMap ;
//    public IteratorMap(ConcurrentHashMap<String, String> hashMap ){
//        this.hashMap = hashMap;
//    }
//    public void run() {
//        hashMap.remove("t4");
//        //hashMap.put("t5","test5");
//    }
//}



//
//public class ConcurrentIteratorModify {
//    public static void main(String[] args) {
//        HashMap<String, String> hashMap = new HashMap<String, String> ();
//        hashMap.put("t1","test1");
//        hashMap.put("t2","test2");
//        hashMap.put("t3","test3");
//        hashMap.put("t4","test4");
//
//        IteratorMap itMap = new IteratorMap(hashMap);
//        Thread thread = new Thread(itMap);
//
//        Collection<String> valus = hashMap.values();
//        Iterator it = valus.iterator();
//        thread.start();
//        for (;it.hasNext();) {
//            System.out.println(it.next());
//        }
//    }
//}
//class IteratorMap implements Runnable{
//    HashMap<String, String> hashMap ;
//    public IteratorMap(HashMap<String, String> hashMap ){
//        this.hashMap = hashMap;
//    }
//    public void run() {
//        //hashMap.remove("t4");
//        hashMap.put("t5","test5");
//    }
//}
