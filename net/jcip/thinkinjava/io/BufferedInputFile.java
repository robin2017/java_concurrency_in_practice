package net.jcip.thinkinjava.io;

/**
 * Created by robin on 2017/7/19.
 */
//: io/BufferedInputFile.java
import java.io.*;

public class BufferedInputFile {
    // Throw exceptions to console:
    public static String
    read(String filename) throws IOException {
        // Reading input by lines:
        BufferedReader in = new BufferedReader(
                new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while((s = in.readLine())!= null)
            sb.append(s + "\n");
        in.close();
        DataInputStream dataInputStream;
        return sb.toString();
    }

    public static void main(String[] args)
            throws IOException {
        System.out.print(read("net/jcip/thinkinjava/io/BufferedInputFile.java"));
    }
} /* (Execute to see output) *///:~


class MemoryInput {
    public static void main(String[] args)
            throws IOException {


        ObjectInputStream objectInputStream;


        String  file=new String("filename");
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while((s = in.readLine()) != null )
            out.println(lineCount++ + ": " + s);
        out.close();
        // Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }
}