package com.iweb.DAO;

import com.iweb.pojo.Product;
import com.iweb.pojo.User;

import java.util.Collection;
import java.util.List;

/**
 * @author YangXinYue
 * @date 2023/7/18 10:29
 */
public interface UserDAO {
    /**用于向用户表插入普通用户数据的方法（注册）
     * 主键使用自增长id
     * @param u 将需要插入的name或password等封装在一个用户对象中
     */
    void insert(User u);



    /**  通过用户提供的用户名和密码查询该用户所有信息  (用于登录和注册避免重名)
     * @param userName
     * @return
     */
    List<User> listLogin(String userName);

//    /**用于所有表的删除数据方法（注销）
//     * @param u 如果传入的对象的id不为空 其余字段为空 则根据id删除
//     *          如果传入的对象的id为空 则根据其余可用字段删除
//     */
//    void delete(Users u);
//
//
//    /**根据提供的某字段值修改指定用户的部分信息
//     * @param u 需要提供被修改的表字段和更新后的字段值
//     */
//    void update(Users u);


    /**查询单件商品数据信息（用户查看商品）
     * @param productName
     * @return
     */
    List<Product> list(String productName);


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






}
