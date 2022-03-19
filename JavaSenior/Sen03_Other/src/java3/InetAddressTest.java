package java3;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * 一、网络编程中的两个要素：
 * 1.对应问题一：IP和端口号
 * 2.对应问题二：提供网络通信协议：TCP/IP参考模型(应用层、传输层、网络层、物理+数据链路
 *
 * 二、通信要素一：IP和端口号
 *
 * 1.IP:唯一的标识 Internet上的计算机(通信实体)
 * 2.在Java中使用InetAddress类代表IP
 * 3.IP分类：IPv4 和IPv6 ；万维网 和 局域网
 * 4.域名
 * 5.本地回路地址：127.0.0.1 对应着：Localhost
 *
 * 6.实例化InetAddress:两个方法：getByName(String host)  、 getLocalHost()
 *                    两个常用方法：getHostName() / getHostAddress()
 *
 * 7.端口号：正在计算机上运行的进程
 *   要求：不用进程用不用的端口号
 *   范围：被规定为一个16 位的整数0~65535
 *
 * 8.端口号与IP地址的组合得出一个网络套接字：Socket
 *
 *
 * @create 2021-10-26 18:31
 */
public class InetAddressTest {
    public static void main(String[] args) {

        try {
            InetAddress in = InetAddress.getByName("192.168.1.1");
            System.out.println(in);

            InetAddress in1 = InetAddress.getByName("www.baidu.com");
            System.out.println(in1);

            //本机地址
            InetAddress in2 = InetAddress.getByName("127.0.0.1");
            System.out.println(in2);
            //本机地址
            InetAddress in3 = InetAddress.getLocalHost();
            System.out.println(in3);

            //getHostName()    域名
            System.out.println(in1.getHostName());
            //getHostAddress()   IP地址
            System.out.println(in1.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
