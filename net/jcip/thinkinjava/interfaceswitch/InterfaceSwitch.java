package net.jcip.thinkinjava.interfaceswitch;

/**
 * Created by robin on 2017/7/15.
 */



interface StudentName{
    int ROBIN=1,FKR=2,ZJR=3;
}
public class InterfaceSwitch {
    public static void main(String[] args){
        int name=StudentName.ROBIN;
        getMoney(name);
    }
    public static void  getMoney(int name){
        switch(name){
            case StudentName.ROBIN:System.out.println("200");break;
            case StudentName.FKR:System.out.println("300");break;
            case StudentName.ZJR:System.out.println("100");break;
        }
    }
}