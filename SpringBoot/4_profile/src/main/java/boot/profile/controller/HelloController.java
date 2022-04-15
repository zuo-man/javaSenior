package boot.profile.controller;

import boot.profile.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    //获取动态配置文件中的值， ：若取不到则使用默认值无暇
    @Value("${person.name:无暇}")
    private String name;

    @GetMapping("/")
    public String hello(){

        return "Hello " + name;
    }


    @Autowired
    private Person person;

    @GetMapping("/person")
    public String person(){

        return person.getClass().toString();
    }


    //获取安装目录
    @Value("${MAVEN_HOME}")
    private String msg;

    @GetMapping("/msg")
    public String getMag(){
        return msg;
    }

}
