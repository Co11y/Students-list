package DAO;

import javax.xml.crypto.Data;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {

    private static  Properties prop;

    static {
        try (InputStream input = DataSource.class.getClassLoader().getResourceAsStream("config.properties")) {

             prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }

            //load a properties file from class path, inside static method
            prop.load(input);
            Class.forName(prop.getProperty("driverName"));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static Connection getConnection() {
        try {
            return DriverManager
                    .getConnection(prop.getProperty("url"), prop.getProperty("user"),
                            prop.getProperty("password"));
        } catch (SQLException e) {
            throw new IllegalStateException(
                    "Unable to create datasource due: " + e.getMessage(), e);
        }
    }
}