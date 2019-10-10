package com.example.foodmanage.mapper;


import com.example.foodmanage.bo.CommodityBO;
import com.example.foodmanage.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/10 10:35
 * @Description: 商品的数据访问层
 */
@Mapper
public interface CommodityMapper {

    /**
     * 查询商品的信息
     * @param commodity
     * @return
     */
    List<Commodity> queryAll(CommodityBO commodity);



}
