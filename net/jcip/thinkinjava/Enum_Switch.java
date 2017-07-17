package net.jcip.thinkinjava;

/**
 * Created by robin on 2017/7/14.
 */
//enum类似与class
enum StudentName{
    ROBIN,FKR,ZJR
}
public class Enum_Switch {
    public static void main(String[] args){
        //赋值
        Object ojb;
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


