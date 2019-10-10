package com.example.foodmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/10 16:49
 * @Description:
 */
@Controller
public class IndexController {

    @GetMapping("")
    public String index(){
        return "redirect:/storeinfo/query";
    }

}
