package com.shop.entity;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.springframework.stereotype.Component;
import java.io.InputStream;

import java.util.Properties;

/**
 * SFTP 上传至云服务器工具类
 * 访问方式使用 Nginx
 */
@Component
public class SFtpUtil {

    //Sftp服务器ip地址
    private static final String SFTP_ADDRESS = "47.96.175.143";
    //端口号
    private static final int SFTP_PORT = 22;
    //用户名
    private static final String SFTP_USERNAME = "root";
    //密码
    private static final String SFTP_PASSWORD = "Fwqlj123";
    //路径
    private final String SFTP_BASEPATH = "/usr/local/nginx/html";

    //参数传过来了文件、文件的输入流、文件存储路径
    public void uploadFile(String originFileName, InputStream input, String path) throws Exception{

        JSch jSch = new JSch();
        Session session = jSch.getSession(SFTP_USERNAME, SFTP_ADDRESS, SFTP_PORT);
        if (SFTP_PASSWORD != null) {
            session.setPassword(SFTP_PASSWORD);
        }

        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();
        Channel channel = session.openChannel("sftp");
        channel.connect();
        ChannelSftp sftp = (ChannelSftp) channel;

        //上传文件到指定路径
        sftp.cd(SFTP_BASEPATH + path);
        //开始上传
        sftp.put(input, originFileName);
    }


}

