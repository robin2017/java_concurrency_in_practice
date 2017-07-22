package net.jcip.thinkinjava.annotations.helloworld;

/**
 * Created by robin on 2017/7/22.
 */
import java.lang.reflect.InvocationTargetException;

public class TestHelloWorldAnnotation {

//    @Test
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        new TestHelloWorldAnnotation().testHello();
    }
    public void testHello() throws IllegalArgumentException,
            IllegalAccessException, InvocationTargetException,
            SecurityException, NoSuchMethodException, InstantiationException {

        //定义操作类


        //假设我们知道类HelloWorldStub使用了注解，执行HelloWorldStub中带注解的方法
        //判断是否使用了注解的name()方法，设置name = "小明"，并返回"小明 say hello world!"

        System.out.println(new ParseAnnotationStub().parseMethod(HelloWorldStub.class));

    }
}