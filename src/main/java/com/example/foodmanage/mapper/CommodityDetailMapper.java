package com.example.foodmanage.mapper;

import com.example.foodmanage.entity.Commodity;
import com.example.foodmanage.entity.CommodityDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    /**
     * 根据传入的信息 显示套餐信息
     * @param commodityDetail
     * @return 套餐实体
     */
    CommodityDetail detailCom(CommodityDetail commodityDetail);



}

