package net.jcip.thinkinjava;

/**
 * Created by robin on 2017/7/15.
 */


class Father{
    public void func(){
        System.out.println("father func");
    }
}
class Son extends Father {
    public void func(){
        //func();   StackOverflowError
        super.func();
    }
}


class ShipControls{
    void forward(int vel){}
    void back(int vel){}
}
//继承模式：使用的是父类的方法，暴露了，不好
class ShipInherit extends ShipControls{
}
//组合模式(隐藏域)
// new ShipConbinationPrivate().forward(100);
class ShipConbinationPrivate{
    private ShipControls shipControls=new ShipControls();
    void forward(int vel){
        shipControls.forward(vel);
    }
    void back(int vel){
        shipControls.back(vel);
    }
}
//组合模式（公开域）
//new ShipConbinationPublic().shipControls.forward(100);
class ShipConbinationPublic{
    public ShipControls shipControls=new ShipControls();
}
//代理模式
//new ShipProxy().forward(100);
class ShipProxy{
    private ShipControls shipControls=new ShipControls();
    void forward(int vel){
        shipControls.forward(vel);
    }
    void back(int vel){
        shipControls.back(vel);
    }
}



class Shape {
    Shape(int i) { System.out.println("Shape constructor"); }
    void dispose() { System.out.println("Shape dispose"); }
}

class Circle extends Shape {
    Circle(int i)
    {
        super(i);
        //DO OTHER CONSTRUCT
        System.out.println("Drawing Circle");
    }
    void dispose()
    {
        //DO OTHER DISPOSE
        System.out.println("Erasing Circle");
        super.dispose();
    }
}

public class FutherAndSon {
    public static void main(String[] args){
        //暴露了父类的方法，使用的是父类的方法，不好
        new ShipInherit().forward(100);
        new ShipConbinationPrivate().forward(100);
        new ShipConbinationPublic().shipControls.forward(100);
        new ShipProxy().forward(100);
    }
}
