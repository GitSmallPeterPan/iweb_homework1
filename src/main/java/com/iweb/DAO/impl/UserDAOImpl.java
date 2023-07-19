package com.iweb.DAO.impl;

import com.iweb.DAO.UserDAO;
import com.iweb.pojo.Product;
import com.iweb.pojo.ShopCar;
import com.iweb.pojo.User;
import com.iweb.service.ShopCarDAO;
import com.iweb.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author YangXinYue
 * @date 2023/7/18 9:17
 */
public class UserDAOImpl implements UserDAO, ShopCarDAO {

//用户注册实现

    @Override
    public void insert(User u) {
        String sql = "insert into user(userName) values(?)";
        try (
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            if (u == null || u.getUserName() == null || u.getUserName().equals("")) {
                System.out.println("请填写您的用户名");
                return;
            }
            ps.setString(1, u.getUserName());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                u.setUserID(id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    用户登录成功判断

    @Override
    public List<User> listLogin(String userName) {
        List<User> userList = new ArrayList<>();
        String sql = "select * from user where userName like concat('%',?,'%')";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3));
                userList.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList.isEmpty() ? null : userList;
    }


    //    用户对商品的查看实现
//  对单件商品

    @Override
    public List<Product> list(String productName) {
        List<Product> productList = new ArrayList<>();
        String sql = "select * from product where productName like concat('%',?,'%')";
        try (
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setString(1, productName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)
                );
                productList.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList.isEmpty() ? null : productList;
    }



//    对多个商品

    @Override
    public List<Product> listAll(int start, int count) {
        return listByPage(0,Integer.MAX_VALUE);
    }

    @Override
    public List<Product> listByPage(int start, int count) {
        List<Product> productList = new ArrayList<>();
        String sql = "select * from product limit ?,?";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)
        ){
            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Product p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)
                );
                productList.add(p);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return (productList.isEmpty())?null:productList;
    }




//  查看购物车

    @Override
    public List<ShopCar> listShopCarAll() {
        return listShopCarByPage(0,Integer.MAX_VALUE);
    }

    @Override
    public List<ShopCar> listShopCarByPage(int start, int count) {
        List<ShopCar> shopCarList = new ArrayList<>();
        String sql = "select * from shopCar limit ?,?";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)
        ){
            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ShopCar s = new ShopCar(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4)
                );
                shopCarList.add(s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return (shopCarList.isEmpty())?null:shopCarList;
    }
}
