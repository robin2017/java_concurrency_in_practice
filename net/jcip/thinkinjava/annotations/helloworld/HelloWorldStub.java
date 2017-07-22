package net.jcip.thinkinjava.annotations.helloworld;

/**
 * Created by robin on 2017/7/22.
 */


public class HelloWorldStub {
    @HelloWorldAnnotation(name = "小明")
    public String sayHello(String name) {
        if (name == null ) {
            name = "";
        }
        return name + " say hello world!";
    }
}
