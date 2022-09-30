package com.vod.service.impl;

import com.atguigu.ggkt.model.vod.VideoVisitor;
import com.atguigu.ggkt.vo.vod.VideoVisitorCountVo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vod.mapper.VideoVisitorMapper;
import com.vod.service.VideoVisitorService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 视频来访者记录表 服务实现类
 * </p>
 */
@Service
public class VideoVisitorServiceImpl extends ServiceImpl<VideoVisitorMapper, VideoVisitor> implements VideoVisitorService {

    //课程统计接口
    @Override
    public Map<String, Object> findCount(Long courseId, String startDate, String endDate) {
        //调用mapper方法
        List<VideoVisitorCountVo> videoVisitorVoList = baseMapper.findCount(courseId, startDate, endDate);

        Map<String, Object> map = new HashMap<>();
        //创建两个List集合，一个代表所有日期，一个代表日期对应数量
        //封装数据
        List<String> dataList = videoVisitorVoList.stream()
                .map(VideoVisitorCountVo::getJoinTime).collect(Collectors.toList());

        List<Integer> countList = videoVisitorVoList.stream()
                .map(VideoVisitorCountVo::getUserCount).collect(Collectors.toList());
        map.put("xData", dataList);
        map.put("yData", countList);

        return map;
    }


}
