package net.jcip.thinkinjava;
//: typeinfo/SimpleProxyDemo.java
 

interface Interface {
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface {
    public void doSomething() { System.out.println("doSomething"); }
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

class RealObjectA implements Interface {
    public void doSomething() { System.out.println("A doSomething"); }
    public void somethingElse(String arg) {
        System.out.println("A somethingElse " + arg);
    }
}

class RealObjectB implements Interface {
    public void doSomething() { System.out.println("B doSomething"); }
    public void somethingElse(String arg) {
        System.out.println("B somethingElse " + arg);
    }
}

 class SimpleProxy implements Interface {
    private Interface proxied;
    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
    }
}

class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
} /* Output:
doSomething
somethingElse bonobo
SimpleProxy doSomething
doSomething
SimpleProxy somethingElse bonobo
somethingElse bonobo
*///:~
