package com.boot.controller;

import com.boot.bean.Dept;
import com.boot.bean.Emp;
import com.boot.bean.User;
import com.boot.service.DeptService;
import com.boot.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    StringRedisTemplate redisTemplate;

    //跳转登录页
    @GetMapping(value = {"/", "/login"})
    public String loginPage(){

        return "login";
    }

    //登录时因为是post请求，刷新时就会重复提交数据，因此需要重定向 到登录页
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        //判断账号，密码是否为123
        if(StringUtils.hasLength(user.getUserName()) && "123".equals(user.getPassword())){
            //把登录成功的用户用 session保存起来，供拦截器获取
            session.setAttribute("loginUser", user);
            //登录成功，重定向到main.html
            return "redirect:/main.html";
        }else {
            model.addAttribute("userError", "账号密码错误");
            //回到登录页面
            return "login";
        }
    }

    //真正跳转到登录页
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model){
        //进入到后台每个页面，需要判断是否登录        拦截器、过滤器

        //直接拦截，有些页面拦截不了，  所以需要拦截器对所有页面进行拦截
//        Object loginUser = session.getAttribute("loginUser");
//        if(loginUser != null){
//            return "main";
//        }else {
//            //回到登录页面
//            model.addAttribute("userError", "请 重新登录");
//            return "login";
//        }

        //获取main页面，sql页面访问次数
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();

        //get：获取redis键对应的值
        String mainCount = opsForValue.get("/main.html");
        String sqlCount = opsForValue.get("/sql");

        model.addAttribute("mainCount", mainCount);
        model.addAttribute("sqlCount", sqlCount);

        return "main";
    }

    //测试SaveDeptTest.html表单 执行保存操作
    @GetMapping(value = {"save"})
    public String SaveDeptTest(){
        return "SaveDeptTest";
    }


    //测试数据连接，获取连接池对象，此时是druid
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    EmpService empService;
    @Autowired
    DeptService deptService;

    @ResponseBody
    @GetMapping("/emp")
                        //@RequestParam：必须要在后面加上 /emp?eid=2
    public Emp getEmpById(@RequestParam("eid") Integer eid){

        //根据service层，用mybatis获取 emp信息
        return empService.getEmpByid(eid);
    }

    @ResponseBody
    @PostMapping("/dept")
    //delete 、update、insert是不需要设置返回类型的，都是默认返回一个int
    public int saveDept(Dept dept){

        deptService.saveDept(dept);
        return 1;
    }

    //使用纯注解方式
    @ResponseBody
    @GetMapping("/dept")
    public Dept getDeptById(@RequestParam("did") Integer did){

        //根据serviece层，用mybatis获取 dept信息
        return deptService.getDeptByid(did);
    }

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDB(){
        Long along = jdbcTemplate.queryForObject("select count(1) from t_user", Long.class);
        return along.toString();
    }



}
