package com.example.foodmanage.service.impl;

import com.example.foodmanage.entity.UserInfo;
import com.example.foodmanage.mapper.UserInfoMapper;
import com.example.foodmanage.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/10 11:13
 * @Description:
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public Integer addUserInfo(UserInfo userInfo) {
        return userInfoMapper.addUserInfo(userInfo);
    }

    @Override
    public UserInfo loginUser(UserInfo userInfo) {
        return userInfoMapper.loginUser(userInfo);
    }

    @Override
    public UserInfo selectUserByUserPhone(String phone) {
        return userInfoMapper.selectUserByUserPhone(phone);
    }
}
