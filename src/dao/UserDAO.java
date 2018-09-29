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

    public List<User> findUsersById(int id) {
        List<User> users = new ArrayList<>();
        try (Connection connection = ds.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT first_name, last_name, phone " +
                    "FROM user WHERE parking_id IN(SELECT parking_id FROM user WHERE id = ?)");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String phone = resultSet.getString("phone");
                users.add(new User(firstName, lastName, phone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
