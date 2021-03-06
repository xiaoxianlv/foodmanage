package com.example.foodmanage.service;

import com.example.foodmanage.entity.CommodityDetail;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/10 17:17
 * @Description: 套餐的业务层
 */
public interface CommodityDetailService {

    /**
     * 根据id查询套餐的详细信息
     * @param detailId
     * @return
     */
    CommodityDetail selectOneInfo(Integer detailId);


    /**
     * 根据传入的信息 显示套餐信息
     * @param commodityDetail
     * @return 套餐实体
     */
    CommodityDetail detailCom(CommodityDetail commodityDetail);

}
