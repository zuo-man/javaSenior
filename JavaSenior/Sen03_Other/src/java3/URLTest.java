package java3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * 1.URL(Uniform Resource Locator)的理解:
 * 统一资源定位符，对应着互联网的某一资源地址
 *
 * 2.URL的5个基本结构：
 * *  http://localhost:8080/examples/beauty.jpg?username=Tom
 * *  协议   主机名    端口号  资源地址           参数列表
 * 3.如何实例化:
 * URL url = new URL("http://localhost:8080/examples/beauty.jpg?username=Tom");
 *
 * 4.常用方法：
 * public String getProtocol() 获取该URL的协议名System.out.println(url.getProtocol());
 * public String getHost()     获取该URL的主机名System.out.println(url.getHost());
 * public String getPort()     获取该URL的端口号System.out.println(url.getPort());
 * public String getPath( )    获取该URL的文件路径System.out.println(url.getPath());
 * public String getFile()     获取该URL的文件名System.out.println(url.getFile());
 * public String getQuery( )   获取该URL的查询名System.out.println(url.getQuery());
 *
 * @create 2021-10-26 20:19
 */
public class URLTest {
    public static void main(String[] args) {

        HttpURLConnection urlConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("http://localhost:8080/javaSenior/JavaSenior/Sen03/下载.jpg");

            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.connect();

            is = urlConnection.getInputStream();
            fos = new FileOutputStream("Sen03\\下载3.jpg");

            byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }

            System.out.println("下载完成");









        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(urlConnection != null){
                urlConnection.disconnect();
            }
        }
    }

}
