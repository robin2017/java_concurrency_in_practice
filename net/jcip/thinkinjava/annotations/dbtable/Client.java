package net.jcip.thinkinjava.annotations.dbtable;

/**
 * Created by robin on 2017/7/21.
 */
public class Client {
    public static void main(String[] args) throws ClassNotFoundException {
        TableCreator.process("net.jcip.thinkinjava.annotations.dbtable.Member");
    }
}
