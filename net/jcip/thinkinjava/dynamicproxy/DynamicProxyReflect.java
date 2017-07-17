package net.jcip.thinkinjava.dynamicproxy;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.Properties;

/**
 * Created by robin on 2017/7/17.
 */
public class DynamicProxyReflect {
    public static Object getInstance() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Properties proc = new Properties();
        // 字节输入流来读取配置文件
        FileInputStream in = new FileInputStream("config/config.txt");
        // 集合io关联(此步拿到配置文件)
        proc.load(in);
        String className = proc.getProperty("className");// 类名
        Class clazz = Class.forName("net.jcip.thinkinjava.dynamicproxy." + className);
        return clazz.newInstance();
    }
    public static void letItFly(Fly fly){
        fly.fly();
    }
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        Object obj=getInstance();
        System.out.println(obj.getClass());
        Fly proxyFly = (Fly) Proxy.newProxyInstance(
                Fly.class.getClassLoader(),
                new Class[]{Fly.class},
                new DynamicProxyHandler(obj));
        letItFly(proxyFly);
    }
}
