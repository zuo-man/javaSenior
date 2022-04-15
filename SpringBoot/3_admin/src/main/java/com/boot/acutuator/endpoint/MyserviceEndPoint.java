package com.boot.acutuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

//自定义端点
@Endpoint(id = "myservice")
@Component
public class MyserviceEndPoint {

    /**
     * @ReadOperation ： 是端点的读操作
     */
    @ReadOperation
    public Map getDockerInfo(){
        //http://localhost:8080/actuator/myservice
        return Collections.singletonMap("dockerInfo", "docker 开启了。。。。");
    }

    /**
     * @WriteOperation ：是端点的写操作
     */
    @WriteOperation
    public void stopDocker(){
        System.out.println("docker 停止。。。");
    }
}
