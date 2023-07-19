package com.iweb.test;

import com.iweb.util.DBUtil;
import com.iweb.view.View;

import java.sql.Connection;
import java.sql.Statement;

/**
 * @author YangXinYue
 * @date 2023/7/18 17:58
 */
public class Test1 {
    public static void main(String[] args) {
//        先测试连接数据库

        String sql = "insert into manager(managerName) values('杨欣月')";
        try(
                Connection c = DBUtil.getConnection();
                Statement s = c.createStatement()
                ){
            s.execute(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
