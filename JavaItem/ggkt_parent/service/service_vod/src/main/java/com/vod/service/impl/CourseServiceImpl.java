package com.vod.service.impl;

import com.atguigu.ggkt.model.vod.Course;
import com.atguigu.ggkt.model.vod.CourseDescription;
import com.atguigu.ggkt.model.vod.Subject;
import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.vo.vod.CourseFormVo;
import com.atguigu.ggkt.vo.vod.CoursePublishVo;
import com.atguigu.ggkt.vo.vod.CourseQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vod.mapper.CourseMapper;
import com.vod.service.ChapterService;
import com.vod.service.CourseDescriptionService;
import com.vod.service.CourseService;
import com.vod.service.SubjectService;
import com.vod.service.TeacherService;
import com.vod.service.VideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private CourseDescriptionService descriptionService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private ChapterService chapterService;

    //添加课程基本信息
    @Override
    public Long saveCourseInfo(CourseFormVo courseFormVo) {
        //添加课程基本信息，操作course表
        Course course = new Course();
        //beanUtils：把一个对象中的值赋值 到另一个对象上
        //          名称一样，复制，  名称不一样，不复制
        BeanUtils.copyProperties(courseFormVo, course);
        baseMapper.insert(course);

        //添加课程描述信息，操作course_description表，与课程表一对一关系
        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setDescription(courseFormVo.getDescription());
        //设置课程id  课程表id与课程描述表id对应相同
        courseDescription.setId(course.getId());
        descriptionService.save(courseDescription);

        return null;
    }

    //修改：根据id获取课程信息
    @Override
    public CourseFormVo getCourseInfoById(Long id) {
        //课程基本信息（课程表）
        Course course = baseMapper.selectById(id);
        if(course == null){
            return null;
        }
        //课程描述信息（课程描述表）
        CourseDescription courseDescription = descriptionService.getById(id);

        //将两信息 封装到同一个对象中
        CourseFormVo courseFormVo = new CourseFormVo();
        BeanUtils.copyProperties(course, courseFormVo); //封装基本信息
        //封装描述
        if(courseDescription != null){
            courseFormVo.setDescription(courseDescription.getDescription());
        }

        return courseFormVo;
    }
    //修改课程信息
    @Override
    public void updateCourseId(CourseFormVo courseFormVo) {
        //修改课程基本信息
        Course course = new Course();
        BeanUtils.copyProperties(courseFormVo, course);
        baseMapper.updateById(course);

        //修改课程描述信息
        CourseDescription description = new CourseDescription();
        description.setDescription(courseFormVo.getDescription());
        //设置课程描述ID
        description.setId(course.getId());
        descriptionService.updateById(description);
    }

    //点播课程列表，条件查询带分页
    @Override
    public Map<String, Object> findPageCourse(Page<Course> pageParam, CourseQueryVo courseQueryVo) {
        //获取条件值
        String title = courseQueryVo.getTitle();
        Long subjectId = courseQueryVo.getSubjectId();  //二层分类
        Long subjectParentId = courseQueryVo.getSubjectParentId();  //一层分类
        Long teacherId = courseQueryVo.getTeacherId();

        //判断条件为空，封装条件
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(title)){
            wrapper.like("title", title);   //模糊查询
        }
        if(!StringUtils.isEmpty(subjectId)){
            wrapper.eq("subject_id", subjectId);
        }
        if(!StringUtils.isEmpty(subjectParentId)){
            wrapper.eq("subject_parent_id", subjectParentId);
        }
        if(!StringUtils.isEmpty(teacherId)){
            wrapper.eq("teacher_id", teacherId);
        }

        //调用方法实现条件查询分页
        Page<Course> pages = baseMapper.selectPage(pageParam, wrapper);
        long totalCount = pages.getTotal(); //总记录数
        long totalPage = pages.getPages();  //总页数
        List<Course> list = pages.getRecords();

        //查询 课程数据中有几个ID     讲师id（一层）  课程分类ID（二层）
        //获取这些 id对应名称，进行封装，最终显示（课程类Course继承 BaseEntity，BaseEntity有其他参数对应 Map集合）
        list.stream().forEach(item ->{
            this.getNameById(item);
        });

        //封装数据并返回
        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", totalCount);
        map.put("totalPage", totalPage);
        map.put("records", list);

        return map;
    }

    //获取这些 id对应名称，进行封装，最终显示
    private Course getNameById(Course course) {
        //根据讲师 id获取讲师名称
        Teacher teacher = teacherService.getById(course.getTeacherId());
        if(teacher != null){
            String name = teacher.getName();
            course.getParam().put("teacherName", name);
        }

        //根据课程分类 id获取课程分类名称
        Subject subjectOne = subjectService.getById(course.getSubjectParentId());
        if(subjectOne != null){
            course.getParam().put("subjectParentTitle", subjectOne.getTitle());
        }
        Subject subjectTwo = subjectService.getById(course.getSubjectId());
        if(subjectTwo != null){
            course.getParam().put("subjectTitle", subjectTwo.getTitle());
        }

        return course;
    }

    //根据课程 id查询发布课程信息
    @Override
    public CoursePublishVo getCoursePublishVo(Long id) {
        return baseMapper.selectCoursePublishVoById(id);
    }

    //课程最终发布
    @Override
    public void publishCourse(Long id) {
        Course course = baseMapper.selectById(id);
        course.setStatus(1);    //1：发布该课程
        course.setPublishTime(new Date());
        baseMapper.updateById(course);
    }

    //删除课程
    @Override
    public void removeCoursId(Long id) {
        //根据课程 id删除小节
        videoService.removeVideoByCourseId(id);

        //根据课程 id删除章节
        chapterService.removeChapterByCourseId(id);

        //根据课程 id删除课程描述
        descriptionService.removeById(id);

        //根据课程 id删除课程
        baseMapper.deleteById(id);
    }

}
