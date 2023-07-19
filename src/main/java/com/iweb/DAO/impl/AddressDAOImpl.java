package com.iweb.DAO.impl;

import com.iweb.DAO.AddressDAO;
import com.iweb.pojo.Address;
import com.iweb.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author YangXinYue
 * @date 2023/7/18 11:58
 */
public class AddressDAOImpl implements AddressDAO {
    @Override
    public void insert(Address a) {
        String sql = "insert into address(userID,consigneeName,address,consigneePhoneNumber) values(?,?,?,?)";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ){
            if (a == null||a.getConsigneeName()==null||a.getConsigneeName().equals("")||a.getAddress()==null||a.getAddress().equals("")||a.getConsigneePhoneNumber()==null||a.getConsigneePhoneNumber().equals("")){
                System.out.println("请完善您的所有收货信息");
                return;
            }
            ps.setInt(1,a.getUserID());
            ps.setString(2,a.getConsigneeName());
            ps.setString(3,a.getAddress());
            ps.setString(4,a.getConsigneePhoneNumber());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                int id = rs.getInt(1);
                a.setAddressID(id);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
