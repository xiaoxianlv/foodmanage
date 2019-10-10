package com.example.foodmanage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/10 10:19
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commodity {

    private Integer commodityid,storeid;
    private  String commodityname;


}
