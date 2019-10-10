package com.example.foodmanage.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/10 16:58
 * @Description: 商品查询的bo对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommodityBO {
    private Integer commodityid;
    private Integer storeid;
    private String commodityname;
    private Integer detailid;
    private Integer detailsize;
    private Integer temperature;
    private String detailname;
    private Float commodityprice;
}
