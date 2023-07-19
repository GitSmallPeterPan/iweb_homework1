package com.iweb.DAO;

import com.iweb.pojo.*;

import java.util.Collection;
import java.util.List;

/**
 * @author YangXinYue
 * @date 2023/7/18 15:50
 */
public interface ManagerPowerDAO {
//    管理员登录
    /**用于管理员用户的信息查询（登录）
     * @param managerName 需要提供管理员用户名
     * @return
     */
    List<Manager> listLogin(String managerName);


//    对商品的管理
    /**增加商品数据 （管理员）
     * @param p
     */
    void insert(Product p);


    /**删除商品数据 （管理员）
     * @param p 根据productName或productId 删除
     */
    void delete(Product p);


    /**更新商品信息 （管理员）
     * @param p
     */
    void update(Product p);

//  对单件商品信息查看

    /**查询单件商品数据信息（用户和管理员）
     * @param productName
     * @return
     */
    List<Product> list(String productName);


//    多件商品查看

    /**分页查询商品表
     * @param start
     * @param count
     * @return
     */
    List<Product> listByPage(int start, int count);


    /**查询所有现有商品信息
     * @param start
     * @param count
     * @return
     */
    List<Product> listAll(int start, int count);





//    对于属性的管理
    /**用于管理员对商品属性表增加数据
     * @param p
     */
    void insert(ProductStats p);


    /**删除商品属性表的属性 （管理员）
     * @param p 根据Name或Id 删除
     */
    void delete(ProductStats p);


    /**更新商品属性表内容 （管理员）
     * @param p
     */
    void update(ProductStats p);




//    对订单查看
    /**对订单表查看
     * @param userID  根据用户id查看
     * @return
     */
    List<Orders> listOrders(int userID);

//    对订单内容查看

    /**对订单内容表查看
     * @param orderID 根据订单id查询
     * @return
     */
    List<OrderContent> listOrderItems(int orderID);



}
