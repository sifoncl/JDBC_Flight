package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {

    private static final String URL = dbPropertiesLoader.get("url");
    private static final String USERNAME = dbPropertiesLoader.get("username");
    private static final String PASSWORD = dbPropertiesLoader.get("password");

    private ConnectionManager() {

    }


    public static Connection open() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к бд");
            throw new RuntimeException(e) {
            };
        }
    }

}
