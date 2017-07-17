package net.jcip.thinkinjava.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by robin on 2017/7/17.
 */
//两个接口
interface Fly{
    void fly();
}

interface Run{
    void run();
}
//四个真实对象类
class Bird implements Fly{
    @Override
    public void fly() {
        System.out.println("我是小鸟，我要飞");
    }
}
class AirCraft implements Fly{
    @Override
    public void fly() {
        System.out.println("我是飞机，我要飞");
    }
}
class Dog implements Run{
    @Override
    public void run() {
        System.out.println("我是小狗，我要跑");
    }
}
class Cat implements Run{
    @Override
    public void run() {
        System.out.println("我是小猫，我要跑");
    }
}
//这个是模版(java编程思想和设计模式),不用动的,如果有需要添加todo
class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        preRequest();
        method.invoke(proxied, args);
        postRequest();
        return null;
    }
    private void preRequest() {
        //TODO
    }
    private void postRequest() {
        //TODO
    }
}
public class DynamicProxy {
    public static void letItFly(Fly fly){
        fly.fly();
    }
    public static void letItRun(Run run){
        run.run();
    }
    public static void main(String[] args){
        Fly fly1=new Bird();
        Fly fly2=new AirCraft();
        Run run1=new Dog();
        Run run2=new Cat();

        Fly proxyFly = (Fly) Proxy.newProxyInstance(
                        Fly.class.getClassLoader(),
                        new Class[]{Fly.class},
                        new DynamicProxyHandler(fly1));
        letItFly(proxyFly);

        proxyFly=(Fly) Proxy.newProxyInstance(
                Fly.class.getClassLoader(),
                new Class[]{Fly.class},
                new DynamicProxyHandler(fly2));
        letItFly(proxyFly);

        Run proxyRun=(Run) Proxy.newProxyInstance(
                Run.class.getClassLoader(),
                new Class[]{Run.class},
                new DynamicProxyHandler(run1));
        letItRun(proxyRun);

        proxyRun=(Run) Proxy.newProxyInstance(
                Run.class.getClassLoader(),
                new Class[]{Run.class},
                new DynamicProxyHandler(run2));
        letItRun(proxyRun);
    }
}
