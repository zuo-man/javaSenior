package com.plusX.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.plusX.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author Dell
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-04-15 15:35:05
* @Entity com.plusX.pojo.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {

    int insertSelective(User user);

    int deleteByUidAndUserName(@Param("uid") Long uid, @Param("userName") String userName);

    int updateAgeAndSexByUid(@Param("age") Integer age, @Param("sex") Integer sex, @Param("uid") Long uid);

    List<User> selectAgeAndSexByAgeBetween(@Param("beginAge") Integer beginAge, @Param("endAge") Integer endAge);

    List<User> selectAllOrderByAgeDesc();

    List<User> selectByAgeAndUserName(@Param("age") Integer age, @Param("userName") String userName);


}




