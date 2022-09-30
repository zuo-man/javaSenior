package cn.jju.it.model;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Component
public class CourseClasses {
    private int id;
    @ApiModelProperty("班级id")
    private int classesId;
    @ApiModelProperty("课程id")
    private int courseId;
    @ApiModelProperty("授课教师id")
    private int teacherId;
}
