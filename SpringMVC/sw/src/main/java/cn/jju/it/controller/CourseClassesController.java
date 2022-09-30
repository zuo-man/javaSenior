package cn.jju.it.controller;

import cn.jju.it.mapper.CourseClassesMapper;
import cn.jju.it.model.CourseClasses;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api("课程班级控制器")
@RequestMapping("/courseclasses")
public class CourseClassesController {
	
    @Autowired
    CourseClassesMapper mapper;
    
    @ApiOperation("获得某个教师的班级授课列表")
    @GetMapping("/getByTeacher")
    @ResponseBody
    public List<CourseClasses> getByTeacher(int teacherId){
        System.out.println("123");
        return mapper.getByTeacher(teacherId);
    }
}
