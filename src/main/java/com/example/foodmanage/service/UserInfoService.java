package com.example.foodmanage.service;

import com.example.foodmanage.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/10 11:13
 * @Description:
 */
public interface UserInfoService {

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
    UserInfo selectUserByUserPhone(String phone);


}
