package com.iweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author YangXinYue
 * @date 2023/7/17 19:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    private int orderID;
    private int userID;
    private int addressID;
    private String orderCreateDate;

}
