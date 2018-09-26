package dao;

import beans.User;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserDAO {

    @Resource(mappedName = "jdbc/parking")
    DataSource ds;

    public List<User> findAllUssers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = ds.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT first_name, last_name, phone FROM user");
            findUsers(users, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<User> findbyUser(int id) {
        List<User> users = new ArrayList<>();
        try (Connection connection = ds.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT first_name, last_name, phone " +
                    "FROM user WHERE parking_id IN(SELECT parking_id FROM user WHERE id = ?)");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            findUsers(users, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private void findUsers(List<User> users, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String phone = resultSet.getString("phone");
            users.add(new User(firstName, lastName, phone));
        }
    }


}
