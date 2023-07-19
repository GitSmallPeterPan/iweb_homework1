package com.iweb.util;

import com.iweb.DAO.ManagerPowerDAO;
import com.iweb.DAO.impl.ManagerPowerDAOImpl;
import com.iweb.pojo.*;

import java.util.List;
import java.util.Scanner;

/**
 * @author YangXinYue
 * @date 2023/7/18 11:38
 */
public class MLogin {
    static Scanner sc = new Scanner(System.in);

    public static void login() {
        System.out.println("请输入您的管理员用户名：");
        String inputManagerName = sc.nextLine();

        ManagerPowerDAO managerPowerDAO = new ManagerPowerDAOImpl();
        List<Manager> managerList = managerPowerDAO.listLogin(inputManagerName);
        if (managerList ==null){
            System.out.println("管理员用户不存在，请检查用户名是否正确");
            login();
        }else {
            System.out.println("管理员登陆成功!");
            return;
        }
    }


    static ManagerPowerDAO managerPowerDAO = new ManagerPowerDAOImpl();
//    1.查看单件/多件商品

    public static void control1(){
        List<Product> productList = managerPowerDAO.listAll(0,Integer.MAX_VALUE);
        System.out.println(productList);

        System.out.println("请问您想查看以上哪个商品的详细信息？");
        String inputOpt = sc.nextLine();
        System.out.println("好的，正在为您查询...");
        System.out.println(managerPowerDAO.list(inputOpt));
    }


//    2.管理商品属性

    public static void control2(){
        System.out.println("你要干啥：1.增加 2.删除 3.更改");
        String inputOpt = sc.nextLine();
        if (inputOpt.equals("1")){
            System.out.println("输入你要增加的属性名称：");
            String inputInsert = sc.nextLine();
            ProductStats p = new ProductStats();
            p.setStatsName(inputInsert);
            managerPowerDAO.insert(p);
        }else if (inputOpt.equals("2")){
            System.out.println("输入你要删除的属性名称：");
            String inputDelete = sc.nextLine();
            ProductStats p = new ProductStats();
            p.setStatsName(inputDelete);
            managerPowerDAO.delete(p);
        }else {
            System.out.println("输入你要更改的属性ID：");
            int inputId = Integer.parseInt(sc.nextLine());
            System.out.println("请输入你要将这个属性名称改为：");
            String inputName = sc.nextLine();
            ProductStats p = new ProductStats();
            p.setStatsID(inputId);
            p.setStatsName(inputName);
            managerPowerDAO.update(p);
        }
    }


//    3.管理商品数据

    public static void control3(){
        System.out.println("你要干啥：1.增加 2.删除 3.更改 4.查询所有");
        String inputOpt = sc.nextLine();
        Product p = new Product();
        if (inputOpt.equals("1")){
            System.out.println("输入你要增加的商品名称：");
            String inputName = sc.nextLine();
            System.out.println("输入你要增加的商品所属属性ID：");
            int inputStatsID = Integer.parseInt(sc.nextLine());
            System.out.println("输入你要增加的商品单价：");
            int inputProductPrice = Integer.parseInt(sc.nextLine());
            p.setProductName(inputName);
            p.setStatsID(inputStatsID);
            p.setProductPrice(inputProductPrice);
            managerPowerDAO.insert(p);
        }else if (inputOpt.equals("2")){
            System.out.println("输入你要删除的商品名称：");
            String inputDelete = sc.nextLine();
            p.setProductName(inputDelete);
            managerPowerDAO.delete(p);
        }else if (inputOpt.equals("3")){
            System.out.println("输入你要更改的商品ID：");
            int inputId = Integer.parseInt(sc.nextLine());
            System.out.println("请输入你要将这个商品名称改为：");
            String inputName = sc.nextLine();
            p.setProductID(inputId);
            p.setProductName(inputName);
            managerPowerDAO.update(p);
        }else {
            System.out.println(managerPowerDAO.listAll(0,Integer.MAX_VALUE));
        }

    }


//    4.查看订单/订单内容

    public static void control4(){
        System.out.println("你要看啥：1.订单 2.订单内容");
        String inputOpt = sc.nextLine();
        if (inputOpt.equals("1")){
            System.out.println("请输入你要看的订单所属用户的ID：");
            int inputUserID = Integer.parseInt(sc.nextLine());
            List<Orders> ordersList = managerPowerDAO.listOrders(inputUserID);
            System.out.println(ordersList);
        }else {
            System.out.println("请输入你要看的订单内容所属订单的ID：");
            int inputOrderID = Integer.parseInt(sc.nextLine());
            List<OrderContent> orderContentList = managerPowerDAO.listOrderItems(inputOrderID);
            System.out.println(orderContentList);
        }

    }

}
