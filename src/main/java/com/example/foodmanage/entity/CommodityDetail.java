package com.example.foodmanage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/10 10:23
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommodityDetail {
    private Integer detailid, commodityid, detailsize, temperature;
    private String detailname;
    private Float commodityprice;

}
