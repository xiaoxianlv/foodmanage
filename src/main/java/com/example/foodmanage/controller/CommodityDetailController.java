package com.example.foodmanage.controller;

import com.example.foodmanage.entity.CommodityDetail;
import com.example.foodmanage.service.CommodityDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/10 17:19
 * @Description: 套餐的controller
 */
@Controller
public class CommodityDetailController {

    @Autowired
    private CommodityDetailService commodityDetailService;

    /**
     * 根据套餐的id  查询套餐详情
     * @param detailId
     * @return
     */
    @PostMapping("detailCommodityDetail")
    @ResponseBody
    public CommodityDetail detailCommodityDetail(Integer detailId){
        return commodityDetailService.selectOneInfo(detailId);
    }


}
