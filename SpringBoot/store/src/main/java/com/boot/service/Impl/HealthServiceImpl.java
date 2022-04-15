package com.boot.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.bean.Health;
import com.boot.mapper.HealthMapper;
import com.boot.service.HealService;
import org.springframework.stereotype.Service;


@Service
public class HealthServiceImpl extends ServiceImpl<HealthMapper, Health> implements HealService {


}
