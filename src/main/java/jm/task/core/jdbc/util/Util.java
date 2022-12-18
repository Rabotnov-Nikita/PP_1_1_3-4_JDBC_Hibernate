package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String HOST = "jdbc:mysql://localhost:3306/db_pp_1_1_3-4";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";


    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(HOST, USERNAME,PASSWORD);
            System.out.println("Connection OK");
        } catch (SQLException e) {
            System.err.println("Не удалось подключиться к базе данных");
        }
        return connection;
    }
}
