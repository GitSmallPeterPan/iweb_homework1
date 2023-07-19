package com.iweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YangXinYue
 * @date 2023/7/17 19:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopCar {
    private int shopCarID;
    private int userID;
    private int productID;
    private int productCount;

}
