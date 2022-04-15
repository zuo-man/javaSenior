package boot.profile.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @Profile ：指定在哪个环境下此类才生效
 */

@Profile("prod")
@Component
@ConfigurationProperties("person")
@Data
public class prod {

    private String name;
    private Integer age;
}
