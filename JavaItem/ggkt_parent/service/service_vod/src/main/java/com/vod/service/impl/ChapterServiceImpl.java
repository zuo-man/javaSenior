package com.vod.service.impl;

import com.atguigu.ggkt.model.vod.Chapter;
import com.atguigu.ggkt.model.vod.Video;
import com.atguigu.ggkt.vo.vod.ChapterVo;
import com.atguigu.ggkt.vo.vod.VideoVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vod.mapper.ChapterMapper;
import com.vod.service.ChapterService;
import com.vod.service.VideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {

    @Autowired
    private VideoService videoService;

    //大纲列表
    @Override
    public List<ChapterVo> getTreeList(Long courseId) {
        //定义最终数据 List集合
        List<ChapterVo> finalChaptherList = new ArrayList<>();

        //根据 courseId获取课程中所有章节
        QueryWrapper<Chapter> wrapperChapter = new QueryWrapper<>();
        wrapperChapter.eq("course_id", courseId);
        List<Chapter> chapterList = baseMapper.selectList(wrapperChapter);

        //根据 courseId获取课程中所有小节，lambda表达式
        LambdaQueryWrapper<Video> wrapperVideo = new LambdaQueryWrapper<>();
        wrapperVideo.eq(Video :: getCourseId, courseId);
        List<Video> videoList = videoService.list(wrapperVideo);

        //封装章节
        //遍历所有章节
        for(int i = 0; i < chapterList.size(); i++){
            //得到课程每个章节
            Chapter chapter = chapterList.get(i);
            //将 chapter 装换成 chapterVo 对象
            //beanUtils：把一个对象中的值赋值 到另一个对象上
            //          名称一样，复制，  名称不一样，不复制
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(chapter, chapterVo);

            //得到每个章节对象放到 finalChapterList集合
            finalChaptherList.add(chapterVo);

            //封装章节里面的小节
            //创建List集合用户封装章节所有小节
            List<VideoVo> videoVoList = new ArrayList<>();
            //遍历小节List
            for(Video video:videoList){
                //判断小节是哪个章节下面
                //章节id  和  小节chapter_id
                if(chapter.getId().equals(video.getChapterId())){
                    //将 video 转换成 videoVo对象
                    VideoVo videoVo = new VideoVo();
                    BeanUtils.copyProperties(video, videoVo);
                    //放到 videoVoList
                    videoVoList.add(videoVo);
                }
            }
            //把章节中所有小节集合放到每个章节里
            chapterVo.setChildren(videoVoList);
        }

        return finalChaptherList;
    }

    //根据课程 id删除章节
    @Override
    public void removeChapterByCourseId(Long id) {
        QueryWrapper<Chapter> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", id);
        baseMapper.delete(wrapper);
    }


}
