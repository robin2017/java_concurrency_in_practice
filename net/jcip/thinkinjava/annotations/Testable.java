package net.jcip.thinkinjava.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Test {} ///:~


public class Testable {
    public static void main(String[] args){
        new Testable().testExecute();
    }
    public void execute() {
        System.out.println("Executing..");
    }
    @Test void testExecute() { execute(); }
}



