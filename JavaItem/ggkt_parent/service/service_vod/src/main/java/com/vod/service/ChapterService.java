package com.vod.service;

import com.atguigu.ggkt.model.vod.Chapter;
import com.atguigu.ggkt.vo.vod.ChapterVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 */
public interface ChapterService extends IService<Chapter> {

    List<ChapterVo> getTreeList(Long courseId);

    void removeChapterByCourseId(Long id);
}
