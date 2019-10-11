package com.example.foodmanage.vo;

import com.example.foodmanage.entity.Commodity;
import com.example.foodmanage.entity.StoreInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/11 17:04
 * @Description: 用户的订单vo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOrderVO {

    /**
     * 门店名称
     */
    private StoreInfo storeInfo;

    /**
     * 产品名称
     */
    private Commodity commodity;
    /**
     * 数量
     */
    private Integer count;

    /**
     * 总价
     */
    private Float price;
}
