package com.example.foodmanage.service.impl;

import com.example.foodmanage.bo.CommodityBO;
import com.example.foodmanage.entity.Commodity;
import com.example.foodmanage.mapper.CommodityMapper;
import com.example.foodmanage.service.CommodityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/10 16:55
 * @Description:
 */
@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityMapper commodityMapper;
    @Override
    public PageInfo<Commodity> queryAll(Integer pageNum, Integer pageSize, CommodityBO  commodity) {
        if(pageNum==null){
            pageNum = 1;
        }
        if(pageSize==null){
            pageSize = 3;
        }
        PageHelper.startPage(pageNum, pageSize);
        //查询数据
        List<Commodity> commodityList = commodityMapper.queryAll(commodity);
        //创建pageInfo
        PageInfo<Commodity> pageInfo = new PageInfo<>(commodityList);
        return pageInfo;
    }
}
