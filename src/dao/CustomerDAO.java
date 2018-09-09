package dao;

import beans.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    private Connection connection;

    public CustomerDAO(Connection connection){
        this.connection = connection;
    }

    public List<Customer> findAllCustomers(){
        List<Customer> customers = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from customer");
            while (resultSet.next()){
                customers.add(new Customer(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
