package com.shop.acutuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

//自定义端点
@Endpoint(id = "myservice")
@Component
public class MoonServiceEndPoint {

    /**
     * @ReadOperation ： 端点的读操作
     */
    @ReadOperation
    public Map getDockerInfo(){
        //http://localhost:5000/actuator/myservice
        return Collections.singletonMap("dockerInfo", "docker 开启。。。。");
    }

    /**
     * @WriteOperation ：端点的写操作
     */
    @WriteOperation
    public void stopDocker(){
        System.out.println("docker 停止。。。");
    }
}
