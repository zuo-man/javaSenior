package cn.jju.it.mapper;

import cn.jju.it.model.CourseClasses;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


public interface CourseClassesMapper {

    List<CourseClasses> getByTeacher(int teacherId);
}
