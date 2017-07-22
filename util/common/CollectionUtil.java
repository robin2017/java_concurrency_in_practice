package util.common;

import java.util.Arrays;
import java.util.Collection;
/**集合转化工具类
 * @author robin
 * @version 1.0
 * */
public class CollectionUtil {
    /**集合转化为字符串
     * @parm c 集合
     * @return 字符串
     * */
    public static String collection2str(Collection<?> c) {
        if(c.size() == 0) return "[]";
        StringBuilder result = new StringBuilder("[");
        for(Object elem : c) {
            if(c.size() != 1)
                result.append("\n  ");
            result.append(elem);
        }
        if(c.size() != 1)
            result.append("\n");
        result.append("]");
        return result.toString();
    }
    /**打印集合内容
     * @parm c 集合
     * */
    public static void printCollection(Collection<?> c) {
        System.out.println(collection2str(c));
    }
    /**打印数组内容
     * @parm c 数组
     * */
    public static void printArray(Object[] c) {
        System.out.println(collection2str(Arrays.asList(c)));
    }
}
