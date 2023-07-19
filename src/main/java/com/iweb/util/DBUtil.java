package com.iweb.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author YangXinYue
 * @date 2023/7/17 19:48
 */
public class DBUtil {
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "a12345";
    private static final String URL =
            "jdbc:mysql://localhost:3306/task?characterEncoding=utf8";
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(URL,USER_NAME,PASSWORD);
    }

}
