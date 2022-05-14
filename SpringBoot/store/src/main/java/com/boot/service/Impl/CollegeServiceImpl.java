package com.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.bean.College;
import com.boot.service.CollegeService;
import com.boot.mapper.CollegeMapper;
import org.springframework.stereotype.Service;

/**
* @author Dell
* @description 针对表【college】的数据库操作Service实现
* @createDate 2022-05-02 12:33:52
*/
@Service
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College>
    implements CollegeService{

}




