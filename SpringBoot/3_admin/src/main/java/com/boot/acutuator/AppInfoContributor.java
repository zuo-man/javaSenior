package com.boot.acutuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

//自定义info的信息，也可以在yml配置文件中配置
@Component
public class AppInfoContributor implements InfoContributor {


    /**
     * 可以在info信息中显示自定义的健康信息，yml和配置类的info设置都会生效
     * http://localhost:8080/actuator/info
     */
    @Override
    public void contribute(Info.Builder builder) {

        builder.withDetail("自定义info信息：", "infooooooo")
                .withDetail("如今的版本是：", "1.0");
    }
}
