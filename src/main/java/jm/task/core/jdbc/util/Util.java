package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String HOST = "jdbc:mysql://localhost:3306/db_pp_1_1_3-4";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static SessionFactory factory;


    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(HOST, USERNAME,PASSWORD);
        } catch (SQLException e) {
            System.err.println("Не удалось подключиться к базе данных");
        }
        return connection;
    }
    public static SessionFactory getFactory() {
        if (factory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/db_pp_1_1_3-4?useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "root");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                factory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return factory;
    }
    public static void closeFactory() {
        factory.close();
    }
}
