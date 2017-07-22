/**
 * Created by robin on 2017/7/18.
 */

import java.io.*;

import static net.jcip.thinkinjava.util.Directory2String.traversal;
public class Hello {
    public static void main(String[] args){
        if(args.length == 0)
            System.out.println(traversal("."));
        else
            for(String arg : args)
                System.out.println(traversal(arg));

        InputStream inputStream;
        FileInputStream fileInputStream;
        FilterInputStream filterInputStream;
        BufferedInputStream bufferedInputStream;
        DataInputStream dataInputStream;
        LineNumberInputStream lineNumberInputStream;
        PushbackInputStream pushbackInputStream;
    }
}
