package com.example.shopping.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // SQLite数据库的连接URL, 指定数据库文件的位置
    private static final String URL = "jdbc:sqlite:path_to_your_database.db"; // 例如 "jdbc:sqlite:C:/my_database/shop.db"

    // 获取数据库连接
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // 注册SQLite JDBC驱动
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(URL);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // 处理异常
        }
        return connection;
    }

    // 关闭数据库连接
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
