package com.iweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YangXinYue
 * @date 2023/7/17 19:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderContent {
    private int orderItemID;
    private int orderID;
    private int productID;
    private int productCount;
    private int productAllPrice;

}
