package com.example.foodmanage.mapper;

import com.example.foodmanage.entity.UserInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/10 10:37
 * @Description:
 */
@Mapper
public interface UserInfoMapper {

    /**
     * 新增用户
     * @param userInfo
     * @return
     */
    Integer addUserInfo(UserInfo userInfo);

    /**
     * 登录
     * @param userInfo
     * @return
     */
    UserInfo loginUser(UserInfo userInfo);

    /**
     * 根据手机号去查询用户
     * @param phone
     * @return
     */
    UserInfo selectUserByUserPhone(@Param("phone") String phone);



}
