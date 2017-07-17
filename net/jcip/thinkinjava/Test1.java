package net.jcip.thinkinjava;

/**
 * Created by robin on 2017/7/13.
 */

class Person3{
    String name;
    int age;
    Person3(String name,int age){
        this.name=name;
        this.age=age;
    }
    void print(){
        System.out.println(name+"---"+age);
    }

}
public class Test1 {
    public static void main(String[] args){
        Person3 a=new Person3("robin",24),
               b=new Person3("peter",30);
        a.print();
    }
}
