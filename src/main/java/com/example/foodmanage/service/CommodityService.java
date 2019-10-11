package com.example.foodmanage.service;

import com.example.foodmanage.bo.CommodityBO;
import com.example.foodmanage.entity.Commodity;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/10 16:54
 * @Description: 商品的业务
 */
public interface CommodityService {

    /**
     * 分页查询商品的信息
     * @param commodity
     * @return  PageInfo<Commodity>
     */
    PageInfo<Commodity> queryAll(Integer pageNum, Integer pageSize, CommodityBO  commodity);

    /**
     * 根据商品的id 查询商品的信息
     * @param id
     * @return
     */
    Commodity selectOneCommodity(Integer id);
}
