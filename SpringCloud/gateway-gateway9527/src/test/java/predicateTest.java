import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

@SpringBootTest
@Slf4j
public class predicateTest {

    @Test
    public void test1(){
        ZonedDateTime zb = ZonedDateTime.now(); //默认时区
        System.out.println(zb);
    }

}
