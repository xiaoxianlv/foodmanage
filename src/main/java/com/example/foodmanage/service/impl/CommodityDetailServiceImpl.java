package com.example.foodmanage.service.impl;

import com.example.foodmanage.entity.CommodityDetail;
import com.example.foodmanage.mapper.CommodityDetailMapper;
import com.example.foodmanage.mapper.CommodityMapper;
import com.example.foodmanage.service.CommodityDetailService;
import com.example.foodmanage.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/10 17:18
 * @Description:
 */
@Service
public class CommodityDetailServiceImpl implements CommodityDetailService {

    @Autowired
    private CommodityDetailMapper commodityDetailMapper;

    @Override
    public CommodityDetail selectOneInfo(Integer detailId) {
        return commodityDetailMapper.selectOneInfo(detailId);
    }
}
