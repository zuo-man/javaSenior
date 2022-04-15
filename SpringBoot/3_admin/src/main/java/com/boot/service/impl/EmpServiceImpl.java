package com.boot.service.impl;

import com.boot.bean.Dept;
import com.boot.bean.Emp;
import com.boot.mapper.EmpMapper;
import com.boot.service.EmpService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    EmpMapper empMapper;

    /**
     *  指标监控：   定制Metrics信息，查看getEmp方法被调用了几次
     *  meterRegistry：指标注册中心
     *
     *  http://localhost:8080/actuator/metrics/empService.getEmpByid.count  getEmpByid方法被调用次数：
     */
    Counter counter;
    public EmpServiceImpl(MeterRegistry meterRegistry){
        counter = meterRegistry.counter("empService.getEmpByid.count  getEmpByid方法被调用次数：");
    }


    public Emp getEmpByid(Integer eid){
        //没被调用一次此方法，counter + 1
        counter.increment();

        return empMapper.getEmp(eid);
    }


}
