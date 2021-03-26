package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DemoJdbc {
    public static void main(String[] args) {
        try {
//            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;Glass","DESKTOP-C29LC6D\\Łukasz","");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost;integratedSecurity=true;");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
