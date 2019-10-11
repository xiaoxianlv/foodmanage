package com.example.foodmanage.controller;

import com.example.foodmanage.entity.UserInfo;
import com.example.foodmanage.service.UserInfoService;
import freemarker.template.utility.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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


    /**
     * 去登录
     * @return
     */
    @GetMapping("login")
    public String login(){
        return "login";
    }

    @PostMapping("doLogin")
    public String doLogin(HttpSession session, UserInfo userInfo, Model model){
        //判断对象
        if(ObjectUtils.isEmpty(userInfo)){
            return "403";
        }
        //数据库查询信息
        UserInfo user = userInfoService.loginUser(userInfo);
        if(!ObjectUtils.isEmpty(user)){
            //数据库有用户
            session.setAttribute("userInfo", user);
            return "redirect:/order/myOrder";
        }else{
            model.addAttribute("msg", "登录失败");
            return "login";
        }

    }


    /**
     * 根据手机号查看手机号是否已经注册
     * @param phone
     * @return
     */
    @PostMapping("selectUserByPhone")
    @ResponseBody
    public Map<String,String> selectUserByPhone(String phone){
        //定义返回值
        Map<String, String> map = new HashMap<>();
        //查询用户信息
        UserInfo userInfo = userInfoService.selectUserByUserPhone(phone);
        //判断对象是否为空
        if(ObjectUtils.isEmpty(userInfo)){
            map.put("dataStauts", "success");
            return map;
        }else{
            map.put("dataStauts", "error");
            return map;
        }
    }

    /**
     * 处理注册用户
     * @param userInfo 用户实体类
     * @return json状态码
     */
    @PostMapping("doRegUser")
    @ResponseBody
    public Map<String,String> doRegUser(UserInfo userInfo){
        //定义返回值
        Map<String, String> map = new HashMap<>();
        //注册用户
        Integer result = userInfoService.addUserInfo(userInfo);
        if(result>0){
            map.put("dataStauts", "success");
            return map;
        }else{
            map.put("dataStauts", "error");
            return map;
        }

    }




}
