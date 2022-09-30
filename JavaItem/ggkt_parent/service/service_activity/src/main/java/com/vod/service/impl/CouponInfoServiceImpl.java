package com.vod.service.impl;

import com.atguigu.ggkt.model.activity.CouponInfo;
import com.atguigu.ggkt.model.activity.CouponUse;
import com.atguigu.ggkt.model.user.UserInfo;
import com.atguigu.ggkt.vo.activity.CouponUseQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.client.user.UserInfoFeignClient;
import com.vod.mapper.CouponInfoMapper;
import com.vod.service.CouponInfoService;
import com.vod.service.CouponUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 优惠券信息 服务实现类
 * </p>
 */
@Service
public class CouponInfoServiceImpl extends ServiceImpl<CouponInfoMapper, CouponInfo> implements CouponInfoService {

    @Autowired
    private CouponUseService couponUseService;
    @Autowired
    private UserInfoFeignClient userInfoFeignClient;

    //获取已经使用优惠卷列表（条件查询分页）
    @Override
    public IPage<CouponUse> selectCouponUsePage(Page<CouponUse> pageParam, CouponUseQueryVo couponUseQueryVo) {
        //获取条件
        Long couponId = couponUseQueryVo.getCouponId();
        String couponStatus = couponUseQueryVo.getCouponStatus();
        String getTimeBegin = couponUseQueryVo.getGetTimeBegin();
        String getTimeEnd = couponUseQueryVo.getGetTimeEnd();
        //封装条件
        QueryWrapper<CouponUse> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(couponId)) {
            wrapper.eq("coupon_id",couponId);
        }
        if(!StringUtils.isEmpty(couponStatus)) {
            wrapper.eq("coupon_status",couponStatus);
        }
        if(!StringUtils.isEmpty(getTimeBegin)) {
            wrapper.ge("get_time",getTimeBegin);
        }
        if(!StringUtils.isEmpty(getTimeEnd)) {
            wrapper.le("get_time",getTimeEnd);
        }
        //调用方法条件分页查询
        IPage<CouponUse> pageModel = couponUseService.page(pageParam, wrapper);
        List<CouponUse> couponUseList = pageModel.getRecords();
        //遍历各个对象 ：以下两种方法
//        couponUseList.stream().forEach(item -> {
//            this.getUserInfoById(item);
//        });
        for(CouponUse item : couponUseList){
            this.getUserInfoById(item);
        }

        return pageModel;
    }

    //根据 传递的各个 couponUse对象中的用户Id，通过远程调用得到用户信息
    private CouponUse getUserInfoById(CouponUse couponUse) {
        //获取用户 Id
        Long userId = couponUse.getUserId();
        if(!StringUtils.isEmpty(userId)){
            //远程调用
            UserInfo userInfo = userInfoFeignClient.getById(userId);
            if(userInfo != null){
                couponUse.getParam().put("nickName", userInfo.getNickName());
                couponUse.getParam().put("phone", userInfo.getParam());
            }
        }
        return couponUse;
    }


}
