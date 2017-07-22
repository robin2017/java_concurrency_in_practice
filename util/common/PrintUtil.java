package util.common;

/**打印工具类
 *@author robin
 * @version 1.0
 */
public class PrintUtil {
    /**打印一个对象，并换行
     * @parm obj 被打印对象
     * */
    public static void print(Object obj) {
        System.out.println(obj);
    }
    /**换行
     * */
    public static void print() {
        System.out.println();
    }
    /**打印一个对象，不换行
     * @parm obj 被打印对象
     * */
    public static void printnb(Object obj) {
        System.out.print(obj);
    }
    public static void main(String[] args){
        print("我要换行");
    }

}
