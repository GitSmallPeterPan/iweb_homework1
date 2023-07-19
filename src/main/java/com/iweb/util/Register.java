package com.iweb.util;

import com.iweb.DAO.AddressDAO;
import com.iweb.DAO.UserDAO;
import com.iweb.DAO.impl.AddressDAOImpl;
import com.iweb.DAO.impl.UserDAOImpl;
import com.iweb.pojo.Address;
import com.iweb.pojo.User;

import java.util.List;
import java.util.Scanner;

/**
 * @author YangXinYue
 * @date 2023/7/18 10:05
 */
public class Register {
//注册

    static Scanner sc = new Scanner(System.in);

    public static void register(){
        System.out.println("请输入您的注册用户名：");
        String inputRUserName = sc.nextLine();

        UserDAO userDAO = new UserDAOImpl();
        User user = new User();
        user.setUserName(inputRUserName);


        List<User> userList = userDAO.listLogin(inputRUserName);
        if (userList !=null){
            System.out.println("用户已存在");
            register();
        }else {
            userDAO.insert(user);
            System.out.println("注册成功!");
            Login.login();
            System.out.println("欢迎首次进入购物系统,请完善您的收货信息...");
            addressAdd(user.getUserID());
            System.out.println("即将进入商品大厅...");
            Login.readProduct();
            return;
        }
    }

    public static void addressAdd(int userId){

        System.out.println("请输入您的收货人姓名：");
        String inputConsigneeName = sc.nextLine();
        System.out.println("请输入您的收货地址：");
        String inputAddress = sc.nextLine();
        System.out.println("请输入您的联系方式：");
        String inputConsigneePhoneNumber = sc.nextLine();

        AddressDAO addressDAO = new AddressDAOImpl();
        Address address = new Address();
        address.setConsigneeName(inputConsigneeName);
        address.setAddress(inputAddress);
        address.setConsigneePhoneNumber(inputConsigneePhoneNumber);
        addressDAO.insert(address);
        System.out.println("添加收货信息成功,祝您购物愉快");
        return;
//        可以再添加地址表list方法，打印刚刚存入的信息


    }
}
