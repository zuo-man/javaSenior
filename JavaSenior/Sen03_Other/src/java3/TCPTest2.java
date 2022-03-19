package java3;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例2：客户端发送文件给服务器，服务器将文件保存在本地
 *
 * @create 2021-10-26 19:44
 */
public class TCPTest2 {
    /*
这里涉及到的异常，应该使用try-catch-finally处理
 */
    @Test
    public void client() throws IOException {
        //1.客户端网络套接字：Socket
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
        //2.输出流，传对象
        OutputStream os = socket.getOutputStream();
        //3.
        FileInputStream fis = new FileInputStream(new File("下载.jpg"));
        //4.
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        //5.
        fis.close();
        os.close();
        socket.close();
    }

    /*
    这里涉及到的异常，应该使用try-catch-finally处理
     */
    @Test
    public void server() throws IOException {
        //1.服务器短网络套接字：ServerSocket
        ServerSocket ss = new ServerSocket(9090);
        //2.接收客户端的Socket
        Socket socket = ss.accept();
        //3.
        InputStream is = socket.getInputStream();
        //4.
        FileOutputStream fos = new FileOutputStream(new File("下载1.jpg"));
        //5.
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        //6.
        fos.close();
        is.close();
        socket.close();
        ss.close();

    }

}
