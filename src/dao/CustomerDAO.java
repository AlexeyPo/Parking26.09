package dao;

import beans.Customer;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Stateless
public class CustomerDAO {

    @Resource(mappedName = "jdbc/parking")
    DataSource ds;

    public boolean isCarInDataBase(String carNumber) {
        try (Connection connection = ds.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT id FROM customer WHERE car_number = ?");
            statement.setString(1, carNumber);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                resultSet.getInt("id");
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void addNewCustomer(Customer customer) {
        try (Connection connection = ds.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO customer(first_name," +
                    " last_name, phone, make, model, car_number) VALUES (?,?,?,?,?,?)");
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getPhone());
            statement.setString(4, customer.getMake());
            statement.setString(5, customer.getModel());
            statement.setString(6, customer.getCarNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomers(int id) {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = ds.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer INNER JOIN " +
                    "fact_of_parking fop on customer.id = fop.customer_id inner JOIN user u on fop.user_id = u.id" +
                    " WHERE u.id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            getList(customerList, resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public List<Customer> getAllCarsOnParking(int id) {

        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = ds.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer INNER JOIN fact_of_parking fop on " +
                    "customer.id = fop.customer_id INNER JOIN user u on fop.user_id = u.id " +
                    "WHERE u.id=? AND finish IS NULL");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            getList(customerList, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    private void getList(List<Customer> customerList, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String phone = resultSet.getString("phone");
            String make = resultSet.getString("make");
            String model = resultSet.getString("model");
            String carNumber = resultSet.getString("car_number");
            customerList.add(new Customer(firstName, lastName, phone, make, model, carNumber));
        }
    }
}
