package net.jcip.examples;

/**
 * Created by robin on 2017/5/10.
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;


/**
 * TaskExecutionWebServer
 * <p/>
 * Web server using a thread pool
 *
 * @author Brian Goetz and Tim Peierls
 */
public class TaskExecutionWebServer_robin {
    private static final int NTHREADS = 100;
    private static final Executor exec
            = new MyExecutor();

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                public void run() {
                    handleRequest(connection);
                }
            };
            exec.execute(task);
        }
    }

    private static void handleRequest(Socket connection) {
        // request-handling logic here
    }
}

class MyExecutor implements Executor{
    @Override
    public void execute(Runnable r) {
        //r.run();      //1 串行模式
        //new Thread(r).start();  //2  一个任务一个线程
    }
}