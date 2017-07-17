//package net.jcip.thinkinjava.dynamicproxy;
//
///**
// * Created by robin on 2017/7/16.
// */
////: typeinfo/SimpleDynamicProxy.java
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//
//
//interface Interface {
//    void doSomething();
//
//    void somethingElse(String arg);
//}
//
//class RealObjectA implements Interface {
//    public void doSomething() {
//        System.out.println("A doSomething");
//    }
//
//    public void somethingElse(String arg) {
//        System.out.println("A somethingElse " + arg);
//    }
//}
//
//class RealObjectB implements Interface {
//    public void doSomething() {
//        System.out.println("B doSomething");
//    }
//
//    public void somethingElse(String arg) {
//        System.out.println("B somethingElse " + arg);
//    }
//}
//
////这个是模版(java编程思想和设计模式),不用动的,如果有需要添加todo
//class DynamicProxyHandler implements InvocationHandler {
//    private Object proxied;
//
//    public DynamicProxyHandler(Object proxied) {
//        this.proxied = proxied;
//    }
//
//    public Object invoke(Object proxy, Method method, Object[] args)
//            throws Throwable {
//        preRequest();
//        method.invoke(proxied, args);
//        postRequest();
//        return null;
//    }
//
//    private void preRequest() {
//        //TODO
//    }
//
//    private void postRequest() {
//        //TODO
//    }
//}
//
//class SimpleDynamicProxy {
//    public static void consumer(Interface iface) {
//        iface.doSomething();
//        iface.somethingElse("bonobo");
//    }
//
//    public static void main(String[] args) {
//        RealObjectA realA = new RealObjectA();
//        RealObjectB realB = new RealObjectB();
//
//        Interface proxy = (Interface) Proxy.newProxyInstance(
//                Interface.class.getClassLoader(),
//                new Class[]{Interface.class},
//                new DynamicProxyHandler(realA));
//        consumer(proxy);
//        proxy = (Interface) Proxy.newProxyInstance(
//                Interface.class.getClassLoader(),
//                new Class[]{Interface.class},
//                new DynamicProxyHandler(realB));
//        consumer(proxy);
//
//    }
//} /* Output: (95% match)
//doSomething
//somethingElse bonobo
//**** proxy: class $Proxy0, method: public abstract void Interface.doSomething(), args: null
//doSomething
//**** proxy: class $Proxy0, method: public abstract void Interface.somethingElse(java.lang.String), args: [Ljava.lang.Object;@42e816
//  bonobo
//somethingElse bonobo
//*///:~
