package com.example.foodmanage.controller;

import com.example.foodmanage.entity.StoreInfo;
import com.example.foodmanage.service.StoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/10 16:21
 * @Description: 门店的控制层
 */
@Controller
@RequestMapping("storeinfo")
public class StoreInfoController {

    @Autowired
    private StoreInfoService storeInfoService;

    /**
     * 查询店铺
     *
     * @param storeInfo
     * @param model
     * @return
     */
    @GetMapping("query")
    public String index(StoreInfo storeInfo, Model model) {
        //存入model
        model.addAttribute("storeInfo", storeInfo);
        //查询数据
        List<StoreInfo> storeInfoList = storeInfoService.queryStore(storeInfo);
        model.addAttribute("storeInfoList", storeInfoList);
        return "/store/listStore";
    }
}
