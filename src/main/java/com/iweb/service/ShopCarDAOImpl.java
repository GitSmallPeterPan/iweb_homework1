package com.iweb.service;

import com.iweb.pojo.ShopCar;
import com.iweb.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author YangXinYue
 * @date 2023/7/18 17:46
 */
public class ShopCarDAOImpl implements ShopCarDAO {
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
