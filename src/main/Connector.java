package main;


import dao.CustomerDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Connector {

    CustomerDAO customerDAO;

    private void initConnection() throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/parking", "alexey",
                "0702ksuha");
        customerDAO = new CustomerDAO(connection);
    }
}
