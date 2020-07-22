package be.raja.data;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        return DriverManager.getConnection("jdbc:mysql://moktok.javawebdev.com:33306/raja", "raja",
                "raja2020");

    }
}