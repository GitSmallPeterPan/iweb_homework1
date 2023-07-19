package com.iweb.DAO.impl;

import com.iweb.DAO.ManagerPowerDAO;
import com.iweb.pojo.*;
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
 * @date 2023/7/18 15:51
 */
public class ManagerPowerDAOImpl implements ManagerPowerDAO {
//    管理员登录实现

    @Override
    public List<Manager> listLogin(String managerName) {
        List<Manager> managerList = new ArrayList<>();
        String sql = "select * from manager where managerName like concat('%',?,'%')";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setString(1, managerName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Manager m = new Manager(
                        rs.getInt(1),
                        rs.getString(2)
                );
                managerList.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return managerList.isEmpty() ? null : managerList;
    }




//    管理员对商品增删改查

    @Override
    public void insert(Product p) {
        String sql = "insert into product(productName,statsID,productPrice) values(?,?,?)";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ){
            if (p == null||p.getProductName()==null||p.getProductName().equals("")){
                System.out.println("参数有误，请检查");
                return;
            }
            ps.setString(1,p.getProductName());
            ps.setInt(2,p.getStatsID());
            ps.setInt(3,p.getProductPrice());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                int id = rs.getInt(1);
                p.setProductID(id);
            }
            System.out.println("增加成功！");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Product p) {
        String sql = "delete from product where 1=1";
        if (p == null){
            System.out.println("参数有误 请检查");
            return;
        }
//        if (p.getProductID()>0&&p.getProductName()==null||(p.getProductName().equals(""))){
//            sql = sql+"and productId = ?";
//            try(
//                    Connection c = DBUtil.getConnection();
//                    PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            ){
//                ps.setInt(1,p.getProductID());
//                ps.execute();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }else

            if (p.getProductID()<=0&&p.getProductName()!=null&&!(p.getProductName().equals(""))){
            sql = sql +" and productName = ?";
            try(
                    Connection c = DBUtil.getConnection();
                    PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ){
                ps.setString(1,p.getProductName());
                ps.execute();
                System.out.println("删除成功！");
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    @Override
    public void update(Product p) {
        if(p==null||p.getProductName()==null||p.getProductName().equals("")||p.getProductID()<0){
            System.out.println("参数有误 请检查");
            return;
        }
        String sql = "update product set productName = ? where productID = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ){
            ps.setString(1,p.getProductName());
            ps.setInt(2,p.getProductID());
            ps.execute();
            System.out.println("更新成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


//    对单个商品查询实现

    @Override
    public List<Product> list(String productName) {
        List<Product> productList = new ArrayList<>();
        String sql = "select * from product where productName like concat('%',?,'%')";
        try (
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1,productName);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList.isEmpty()?null: productList;
    }


//    对多个商品查看实现

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


//    对属性的管理

    @Override
    public void insert(ProductStats p) {
        String sql = "insert into productStats(statsName) values(?)";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ){
            if (p == null||p.getStatsName()==null||p.getStatsName().equals("")){
                System.out.println("参数有误 请检查");
                return;
            }
            ps.setString(1,p.getStatsName());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                int id = rs.getInt(1);
                p.setStatsID(id);
            }
            System.out.println("增加成功！");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(ProductStats p) {
        String sql = "delete from productStats where 1=1";
        if (p == null){
            System.out.println("参数有误 请检查");
            return;
        }
//        if (p.getStatsID()>0&&p.getStatsName()==null||(p.getStatsName().equals(""))){
//            sql = sql+"and statsID = ?";
//            try(
//                    Connection c = DBUtil.getConnection();
//                    PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            ){
//                ps.setInt(1,p.getStatsID());
//                ps.execute();
//                System.out.println("删除成功");
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }else
            if (p.getStatsID()<=0&&p.getStatsName()!=null&&!(p.getStatsName().equals(""))){
            sql = sql +" and statsName = ?";
            try(
                    Connection c = DBUtil.getConnection();
                    PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ){
                ps.setString(1,p.getStatsName());
                ps.execute();
                System.out.println("删除成功！");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(ProductStats p) {
        if(p==null||p.getStatsName()==null||p.getStatsName().equals("")||p.getStatsID()<0){
            System.out.println("参数有误 请检查");
            return;
        }
        String sql = "update productStats set statsName = ? where statsID = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ){
            ps.setString(1,p.getStatsName());
            ps.setInt(2,p.getStatsID());
            ps.execute();
            System.out.println("更新成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


//    查看订单

    @Override
    public List<Orders> listOrders(int userID) {
        List<Orders> ordersList = new ArrayList<>();
        String sql = "select * from orders where userID = ?";
        try (
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setInt(1,userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Orders o = new Orders(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4)
                );
                ordersList.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ordersList.isEmpty()?null:ordersList;
    }


//    查看订单内容


    @Override
    public List<OrderContent> listOrderItems(int orderID) {
        List<OrderContent> orderContentList = new ArrayList<>();
        String sql = "select * from ordercontent where orderID = ?";
        try (
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setInt(1,orderID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                OrderContent o = new OrderContent(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5)
                );
                orderContentList.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderContentList.isEmpty()?null:orderContentList;
    }
}
