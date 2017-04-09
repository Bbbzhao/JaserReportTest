package com.wenkang.sqlexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by wenka on 2017/4/9.
 */
public class MySQLConnection
{
    public static Connection getConnection() {
        int flag = 0;
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/test?"
                + "user=root&password=123456&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            System.out.println("成功加载MySQL驱动程序");
            // 一个Connection代表一个数据库连接
            conn = DriverManager.getConnection(url);
            // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
            Statement stmt = conn.createStatement();
        } catch (ClassNotFoundException e) {
            flag = -1;
            System.out.println("找不到驱动类");
        } catch (SQLException e) {
            flag = -1;
            System.out.println("创建数据库连接错误");
        }
        if (flag != -1) {
            System.out.println("创建数据库连接成功");
            return conn;
        }
        return null;
    }

    public static void closeConnection(Connection connection) {
        int flag = 0;
        try {
            connection.close();
        } catch (SQLException e) {
            flag = -1;
            System.out.println("关闭数据库连接出现错误");
        }
        if (flag != -1)
            System.out.println("关闭数据库连接成功");

    }
}
