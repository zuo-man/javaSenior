package com.boot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boot.bean.Emp;
import com.boot.bean.TUser;
import com.boot.bean.User;
import com.boot.exception.UserTooManyException;
import com.boot.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class TableController {

    @Autowired
    TUserService tUserService;

    /**
     * 不带请求参数或者参数类型不对：400； bBad Request  一般都是浏览器的参数没有传递正确
     */
    @GetMapping("/basic_table")
    public String basic_table(@RequestParam("a") int a ){
        int i = 10/0;

        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
                            //传入当前页码pn，默认为 1
    public String dynamic_table(Model model){
        //在dynamic_table中遍历 User
        List<User> users = Arrays.asList(new User("小优", "123"),
                                        new User("无暇", "333"),
//                                        new User("唯", "33"),
                                        new User("千姬", "344"));
        //将所有用户信息 放在Model中， 在由Model转到请求域中
        model.addAttribute("users", users);
        //测试自定义异常
        if(users.size() > 3){
            throw new UserTooManyException();
        }

        return "table/dynamic_table";
    }


    @GetMapping("/editable_table")
                                //传入当前页码，默认为 1
    public String editable_table(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model){

        //不使用分页遍历数据中的 t_user
//        List<TUser> list = tUserService.list();
//        model.addAttribute("tusers", list);


        //分页查询数据    current:当前页码   size：每页显示几条数据
        Page<TUser> tUserPage = new Page<>(pn, 2);
        //分页查询结果，  null为查询所有数据
        Page<TUser> page = tUserService.page(tUserPage, null);
//        long current = page.getCurrent();       //当前页
//        long pages = page.getPages();           //当前分页总页数
//        long total = page.getTotal();           //总记录数

        //因为数据库中的数据已经被page获取，页面中的tusers已无数据，真正查询的所有数据为：Records
//        List<TUser> records = page.getRecords();


        model.addAttribute("page", page);
        return "table/editable_table";
    }

    //删除 t_user
    /**
     *  使用delete请求
     *  使用重定向的跳转方式的情况下，跳转到的地址无法获取 request 中的值。RedirecAtrributes 很好的解决了这个问题
     */
//    @GetMapping("/tuser/delete/{id}")
    @DeleteMapping("/tuser/delete/{id}")
    public String deleteTUser(@PathVariable("id") Integer id,
                              @RequestParam(value = "pn", defaultValue = "1")Integer pn,
                              RedirectAttributes ra){

        tUserService.removeById(id);
        ra.addAttribute("pn", pn);

        return "redirect:/editable_table";
    }



    //1.跳转到添加页面
    @RequestMapping("/AddNew")
    public String AddNew(@RequestParam(value = "last") Integer last, Model model){
        //向添加页面 传输最后一个id至隐藏域
        model.addAttribute("last", last);

        return "det/add_new";
    }
    //2.保存
    @PostMapping("/add_tuser")
    public String addTUser(TUser tUser){
        tUserService.save(tUser);
        System.out.println(tUser);

        return "redirect:/editable_table";
    }


    //修改操作，在html页面中用get、传递过来的id获取 员工信息
    //再用Model将request请求域中的对象传递到update页面上去
    @GetMapping("/tuser/UpDate/{id}")
                        //获取页码pn，再用modelMap传递到 修改页面
    public String Updaet(@PathVariable("id") Integer id,
                         @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                         ModelMap modelMap){
        TUser tuser = tUserService.getById(id);

        modelMap.addAttribute("tuser", tuser);
        modelMap.addAttribute("pn", pn);
        return "det/update_tuser";
    }
    @PutMapping(value = "/updateTUser")
                        //获取modelMap传递过来的pn，重定向回指定页面
    public String updateTUser(TUser tUser,
                              @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                              RedirectAttributes ra){

        tUserService.saveOrUpdate(tUser);
        ra.addAttribute("pn", pn);
        return "redirect:/editable_table";
    }



    @GetMapping("/responsive_table")
    public String responsive_table(){

        return "table/responsive_table";
    }


}
