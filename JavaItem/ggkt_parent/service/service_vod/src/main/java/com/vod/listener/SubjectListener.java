package com.vod.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.atguigu.ggkt.model.vod.Subject;
import com.atguigu.ggkt.vo.vod.SubjectEeVo;
import com.vod.mapper.SubjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//监听器，  导入Excel文件至课程分类 功能需要此监听器
@Component
public class SubjectListener extends AnalysisEventListener<SubjectEeVo> {

    //注入mapper
    @Autowired
    private SubjectMapper subjectMapper;

    //一行一行读取 excel内容，把每行内容封装到 Subject对象
    // 从excel第二行开始读取，第一行内容是表头
    @Override
    public void invoke(SubjectEeVo subjectEeVo, AnalysisContext analysisContext) {
        Subject subject = new Subject();

        //将excel中的各个 subjectEeVo对象 转化成 subject对象
        //BeanUtils：把一个对象中的值赋值 到另一个对象上，     属性一样，复制，属性不一样，不复制
        BeanUtils.copyProperties(subjectEeVo, subject);
        //添加
        subjectMapper.insert(subject);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
