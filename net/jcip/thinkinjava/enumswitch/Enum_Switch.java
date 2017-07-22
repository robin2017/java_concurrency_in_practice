package net.jcip.thinkinjava.enumswitch;

/**
 * Created by robin on 2017/7/20.
 */
enum StudentName{
    ROBIN,FKR,ZJR
}
public class Enum_Switch {
    public static void main(String[] args){
        //赋值
        StudentName person=StudentName.ROBIN;
        getMoney(person);
        //OUTPUT:200
    }
    public static void  getMoney(StudentName name){
        switch(name){
            case ROBIN:System.out.println("200");break;
            case FKR:System.out.println("300");break;
            case ZJR:System.out.println("100");break;
        }
    }
}