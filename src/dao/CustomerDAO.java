package dao;

import beans.Customer;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CustomerDAO {

    @Resource(mappedName = "jdbc/parking")
    DataSource ds;

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = ds.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select first_name, last_name, phone from customer");
            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String phone = rs.getString("phone");
                customers.add(new Customer(firstName, lastName, phone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
