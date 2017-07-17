package net.jcip.thinkinjava.fatherson;

/**
 * Created by robin on 2017/7/16.
 */

class Father{
    public void introduce(){
        System.out.println("i am father");
    }
}
class Son extends Father{
    public void introduce(){
        System.out.println("i am son");
    }
}
public class FatherSonTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Father father=new Son();
        Class<?> fatherType=father.getClass();
        System.out.println(fatherType.getName());
        //OUTPUT:net.jcip.thinkinjava.fatherson.Son
        Object obj=fatherType.newInstance();
        Father fa=(Son)obj;
        fa.introduce();
        //OUT:i am son
    }
}
