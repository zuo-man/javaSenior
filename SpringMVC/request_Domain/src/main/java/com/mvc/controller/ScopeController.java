package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.*;
import java.util.Map;

@Controller
public class ScopeController {

    //使用sevlectAPI向request域对象共享数据
    @RequestMapping("/testRequestServletAPI")
    public String testRequestServletAPI(HttpServletRequest request){
        //请求转发数据到success
        request.setAttribute("testRequestScope", "Hello，servletAPI");
        return "success";
    }

    //使用ModelAndView向request域对象共享数据
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        /**
         * ModelAndView有Model和View的功能
         * Model主要用于向请求域共享数据
         * View主要用于设置视图，实现页面跳转
         */
        ModelAndView mav = new ModelAndView();
        //处理模型数据，即向请求域request共享数据
        mav.addObject("testRequestScope","hello, ModelAndView");
        //设置视图名称
        mav.setViewName("success");
        return mav;
    }

    //向session域共享数据，建议使用Http源生的api
    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope", "hello, Session");
        return "success";
    }

    //向application域共享数据
    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope", "hello, application");
        return "success";
    }




    //使用Model，      Model、ModelMap、Map类型的参数其实本质上都是 BindingAwareModelMap 类型的
    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testRequestScope","hello,Model");
        return "success";
    }

    //使用Map，        Model、ModelMap、Map类型的参数其实本质上都是 BindingAwareModelMap 类型的
    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        map.put("testRequestScope","hello,map");
        return "success";
    }

    //使用ModelMap        ，Model、ModelMap、Map类型的参数其实本质上都是 BindingAwareModelMap 类型的
    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequestScope","hello,ModelMap");
        return "success";
    }

}
