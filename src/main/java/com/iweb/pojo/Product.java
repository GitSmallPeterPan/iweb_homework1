package com.iweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YangXinYue
 * @date 2023/7/17 19:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int productID;
    private String productName;
    private int salesVolume;
    private int evaluate;
    private int statsID;
    private int productPrice;
//    salesVolume
}
