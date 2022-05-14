package com.shop.acutuator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义指标监控的 磁盘健康信息
 */
@Component
public class MoonComHealthIdicator extends AbstractHealthIndicator {

    /**
     * 真实的检查方法
     *
     * 可以在health信息中显示自定义的健康信息
     * http://localhost:5000/actuator/health
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        //mongodb     获取连接进行测试
        Map<String, Object> map = new HashMap<>();

        //假设检查完成
        if(1 == 1){
            //builder.up();   //健康
            //或者写成：
            builder.status(Status.UP);
            map.put("项目运行", "无异常");
            map.put("影响行数为：", 2);
            map.put("执行毫秒数为：", 100);
        }else {
            //builder.down();
            builder.status(Status.DOWN);
            map.put("错误原因是：", "连接超时");
        }

        //withDetail：将信息返回
        builder.withDetail("code", 200).withDetails(map);
    }

}



