package com.example.foodmanage.mapper;

import com.example.foodmanage.entity.CommodityDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/10 10:36
 * @Description: 套餐的mapper
 */
@Mapper
public interface CommodityDetailMapper {

    /**
     * 根据id查询套餐的详细信息
     * @param detailId
     * @return
     */
    CommodityDetail selectOneInfo(@Param("detailId") Integer detailId);


}

