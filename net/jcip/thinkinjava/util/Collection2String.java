package net.jcip.thinkinjava.util;
import java.util.*;
public class Collection2String {
    public static String str(Collection<?> c) {
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
    public static void print(Collection<?> c) {
        System.out.println(str(c));
    }
    public static void print(Object[] c) {
        System.out.println(str(Arrays.asList(c)));
    }
}
