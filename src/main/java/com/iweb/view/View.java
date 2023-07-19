package com.iweb.view;

import com.iweb.util.Login;
import com.iweb.util.MLogin;
import com.iweb.util.Register;

import java.util.Scanner;

/**界面
 * @author YangXinYue
 * @date 2023/7/17 23:34
 */
public class View {
    public void ask(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请问您要登录还是注册？（输入：登录/注册）");
        String answer = sc.nextLine();
        if (answer.equals("登录")){
            System.out.println("请选择：管理员登录(g)/普通用户登录(p)");
            String inputBody = sc.nextLine();
            if (inputBody.equals("p")){
                Login.login();
                System.out.println("即将跳转到商品大厅。。。");
                Login.readProduct();
                System.out.println("请问您要查看您的购物车吗？y/n");
                String inputOpt = sc.nextLine();
                if (inputOpt.equals("y")){
                    Login.readShopCar();
                }else {
                    System.out.println("好的，祝您购物愉快！");
                }
                return;
            }else if (inputBody.equals("g")){
                MLogin.login();
                System.out.println("即将跳转到管理员界面。。。");
                System.out.println("请问您希望完成以下哪项操作：1.查看单件/多件商品 2.管理商品属性 3.管理商品数据 4.查看订单/订单内容");
                String inputOpt = sc.nextLine();
                if (inputOpt.equals("1")){
                    MLogin.control1();
                }else if (inputOpt.equals("2")){
                    MLogin.control2();
                }else if (inputOpt.equals("3")){
                    MLogin.control3();
                }else if (inputOpt.equals("4")){
                    MLogin.control4();
                }else {
                    System.out.println("别以为你是管理员我就不敢喷你~");
                }
            }
        }else if(answer.equals("注册")){
            Register.register();
            return;
        }
    }
}
