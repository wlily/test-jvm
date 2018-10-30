package com.wll.test.jvm.classloader;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class TestThreadContextClassLoader {

    private static void connectMySQL() throws SQLException {
        Connection conn = null;
        // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
        // 避免中文乱码要指定useUnicode和characterEncoding
        String url = "jdbc:mysql://localhost:3306/javademo?"
                + "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
        try {
//            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            System.out.println("load mysql driver successfully");
            conn = DriverManager.getConnection(url);
            System.out.println(Driver.class.getClassLoader());
            System.out.println(DriverManager.class.getClassLoader());

        } catch (SQLException e) {
            System.out.println("MySQL Operate error");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

    public static void main(String[] args) throws SQLException {
        TestThreadContextClassLoader.connectMySQL();
    }
}
