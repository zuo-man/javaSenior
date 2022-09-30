package com.vod.service.impl;

import com.atguigu.ggkt.model.wechat.Menu;
import com.atguigu.ggkt.vo.wechat.MenuVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vod.mapper.MenuMapper;
import com.vod.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 订单明细 订单明细 服务实现类
 * </p>
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    //获取所有菜单，按照一级和二级菜单封装
    @Override
    public List<MenuVo> findMenu() {
        // 1.创建list集合，用户最终数据封装
        List<MenuVo> finalMenuList = new ArrayList<>();
        // 2.查询所有菜单数据（包括一级二级）
        List<Menu> menuList = baseMapper.selectList(null);

        // 3.从所有菜单数据获取所有一级菜单（parent_id = 0） 以java8流方式遍历menuList对象，若ParentId为0，则封装到Collectors类方法的list集合中
        List<Menu> oneMenuList = menuList.stream().filter
                (menu -> menu.getParentId().longValue() == 0).collect(Collectors.toList());

        // 4.封装一级菜单数据，封装到最终数据list集合
        // 遍历一级菜单List集合
        for(Menu oneMenu : oneMenuList){
            //beanUtils：把一个对象中的值赋值 到另一个对象上
            //          名称一样，复制，  名称不一样，不复制
            //将 menu装换成 menuVo
            MenuVo oneMenuVo = new MenuVo();
            BeanUtils.copyProperties(oneMenu, oneMenuVo);

            // 5.封装二级菜单数据（判断一级菜单id和二级菜单parent_id是否相同），以java8流方式遍历所有菜单
            List<Menu> twoMenuList = menuList.stream().filter
                    (menu -> menu.getParentId().longValue() == oneMenu.getId()).collect(Collectors.toList());
            //将 List<Menu>装换成 List<MenuVo>
            List<MenuVo> children = new ArrayList<>();
            for(Menu twoMenu : twoMenuList){
                MenuVo twoMenuVo = new MenuVo();
                BeanUtils.copyProperties(twoMenu, twoMenuVo);
                children.add(twoMenuVo);
            }
            //把二级菜单数据放到一级菜单中
            oneMenuVo.setChildren(children);

            //把 oneMenuVo放到最终list集合
            finalMenuList.add(oneMenuVo);
        }

        return finalMenuList;
    }

    //获取所有一级菜单
    @Override
    public List<Menu> findOneMenu() {
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        //当 id=0时，为一级菜单
        wrapper.eq("parent_id", 0);
        List<Menu> list = baseMapper.selectList(wrapper);
        return list;
    }


}
