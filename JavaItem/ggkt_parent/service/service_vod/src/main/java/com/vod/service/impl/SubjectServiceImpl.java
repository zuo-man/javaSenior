package com.vod.service.impl;

import com.alibaba.excel.EasyExcel;
import com.atguigu.ggkt.model.vod.Subject;
import com.atguigu.ggkt.vo.vod.SubjectEeVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vod.exception.GlobalExceptionHandler;
import com.vod.exception.SlefException;
import com.vod.listener.SubjectListener;
import com.vod.mapper.SubjectMapper;
import com.vod.result.ResultCodeEnum;
import com.vod.service.SubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * eq ： equal等于
 * ne： not equal不等于
 * gt ： greater than大于
 * lt ： less than小于
 * ge ： greater than or equal 大于等于
 * le ： less than or equal 小于等于
 * in ： in 包含（数组）
 * isNull ： 等于null
 * between ： 在2个条件之间(包括边界值)
 * like： 模糊查询
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Autowired
    private SubjectListener subjectListener;

    //课程分类列表
    //懒加载，每次查询一层数据
    @Override
    public List<Subject> selectSubjectList(Long id) {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        //查询特定 id数据
        wrapper.eq("parent_id", id);
        List<Subject> subjectList = baseMapper.selectList(wrapper);

        //subectList遍历，得到每个subject对象，判断是否有下一层数据，有hasChildren=true
        for(Subject subject : subjectList){
            //获取subject的 id值
            Long subjectId = subject.getId();
            //查询
            boolean isChild = this.isChildren(subjectId);
            //封装到对象中
            subject.setHasChildren(isChild);
        }

        return subjectList;
    }
    //判断是否有下一层数据
    private boolean isChildren(Long subjectId) {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        //用 subjectId查询父 parent_id，看是否有下一层数据
        wrapper.eq("parent_id", subjectId);
        Integer count = baseMapper.selectCount(wrapper);

        //1>0 ，则为true，该id是父parent_id，有下一层数据
        //0>0 ，则为false， 该id 没有下一层数据
        return count>0;
    }

    //课程分类导出
    @Override
    public void exportData(HttpServletResponse response) {
        try {
            //设置下载信息
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("课程分类", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename="+ fileName + ".xlsx");

            //查询课程分类表所有数据
            List<Subject> subjectList = baseMapper.selectList(null);

            //List<Subject> 装换成：  List<SubjectEeVo>
            List<SubjectEeVo> subjectEeVoList = new ArrayList<>();
            for (Subject subject: subjectList) {
                SubjectEeVo subjectEeVo = new SubjectEeVo();
                //subjectEeVo.setId(subject.getId());
                //subjectEeVo.setParentId(subject.getParentId());

                //beanUtils：把一个对象中的值赋值 到另一个对象上
                //          名称一样，复制，  名称不一样，不复制
                BeanUtils.copyProperties(subject,subjectEeVo);
                subjectEeVoList.add(subjectEeVo);
            }

            //EasyExcel写操作
            EasyExcel.write(response.getOutputStream(), SubjectEeVo.class)
                    .sheet("课程分类")
                    .doWrite(subjectEeVoList);
        }catch(Exception e) {
            throw new SlefException(20001,"导出失败");
        }
    }

    //课程分类导入
    @Override
    public void importData(MultipartFile file) {
        try {
            //调用方法进行读操作，默认读取第一个sheet
                            // Excel文件流      读取文件所需对象类     监听器
            EasyExcel.read(file.getInputStream(), SubjectEeVo.class, subjectListener)
                    .sheet().doRead();
        } catch (IOException e) {
            throw new SlefException(20001, "导入失败");
        }
    }

}
