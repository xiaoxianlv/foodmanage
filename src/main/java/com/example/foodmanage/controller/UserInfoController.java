package com.example.foodmanage.controller;

import com.example.foodmanage.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/10 11:16
 * @Description: 用户信息的控制处理
 */
@Controller
@RequestMapping("userinfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;
    /**
     * 去用户注册
     * @return
     */
    @RequestMapping("reg")
    public String reg(){
        return "reg";
    }


}
