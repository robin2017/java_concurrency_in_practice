package net.jcip.thinkinjava.io;

import java.io.*;

/**
 * Created by robin on 2017/7/20.
 */
public class Email implements Serializable {
    public Object deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bao=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bao);
        oos.writeObject(this);

        ByteArrayInputStream bis=new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois=new ObjectInputStream(bis);
        return (ois.readObject());
    }
}
