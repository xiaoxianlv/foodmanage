package com.example.foodmanage.controller;

import com.example.foodmanage.entity.CommodityDetail;
import com.example.foodmanage.service.CommodityDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/10 17:19
 * @Description: 套餐的controller
 */
@Controller
@RequestMapping("commoditydetail")
@Slf4j
public class CommodityDetailController {
    @Autowired
    private CommodityDetailService commodityDetailService;
    /**
     * 根据传入的id进行选择
     * @param commodityDetail 套餐的实体
     * @return 价格
     */
    @PostMapping("detailPirce")
    @ResponseBody
    public Map<String,Object> detailPirce(CommodityDetail commodityDetail){
        //设置map返回值状态
        Map<String, Object> map = new HashMap<>();
        //去数据库查询价格
        CommodityDetail commodityinfo = commodityDetailService.detailCom(commodityDetail);
        //判断对象,没有查询到的价格
        if (ObjectUtils.isEmpty(commodityinfo)){
            map.put("mess", "error");
            return map;
        }else{
            map.put("mess", "success");
            map.put("price", commodityinfo.getCommodityprice());
            return map;
        }
    }


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
