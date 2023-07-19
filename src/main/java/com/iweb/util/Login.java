package com.iweb.util;

import com.iweb.DAO.UserDAO;
import com.iweb.DAO.impl.UserDAOImpl;
import com.iweb.pojo.Product;
import com.iweb.pojo.ShopCar;
import com.iweb.pojo.User;
import com.iweb.service.ShopCarDAO;

import java.util.List;
import java.util.Scanner;

/**
 * @author YangXinYue
 * @date 2023/7/18 10:04
 */
public class Login{

    static Scanner sc = new Scanner(System.in);
//    登录
    public static void login() {
        System.out.println("请输入您的用户名：");
        String inputUserName = sc.nextLine();

        UserDAO userDAO = new UserDAOImpl();
        List<User> userList = userDAO.listLogin(inputUserName);
        if (userList ==null){
            System.out.println("用户不存在，请检查用户名是否正确");
            login();
        }else {
            System.out.println("登陆成功!");
            return;
        }
    }

    public static void readProduct(){

        UserDAO userDAO = new UserDAOImpl();
        List<Product> productList = userDAO.listAll(0,Integer.MAX_VALUE);
        System.out.println(productList);

        System.out.println("请问您想查看以上哪个商品的详细信息？");
        String inputOpt = sc.nextLine();
        System.out.println("好的，正在为您查询...");
        System.out.println(userDAO.list(inputOpt));
        return;
    }


    public static void readShopCar(){
        ShopCarDAO shopCarDAO = new UserDAOImpl();
        List<ShopCar> shopCarList = shopCarDAO.listShopCarAll();
        System.out.println("您的购物车如下：");
        System.out.println(shopCarList);
    }


}
