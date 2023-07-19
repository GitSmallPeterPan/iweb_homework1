package com.iweb.service;

import com.iweb.pojo.ShopCar;

import java.util.Collection;
import java.util.List;

/**
 * @author YangXinYue
 * @date 2023/7/18 17:34
 */
public interface ShopCarDAO {

    /**获取购物车所有信息
     * @return 返回购物车所有信息集合
     */
    List<ShopCar> listShopCarAll();

    /**根据购物车信息分页查询
     * @param start limit的第一个参数 表示数据的截取开始行
     * @param count limit的第一个参数 表示数据的截取行数
     * @return 返回分页查询结果 没查询到返回null
     */
    List<ShopCar> listShopCarByPage(int start, int count);

}
