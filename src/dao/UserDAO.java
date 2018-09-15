package dao;

import beans.User;

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
public class UserDAO {

    @Resource(mappedName = "jdbc/parking")
    DataSource ds;

    public List<User> findAllUssers(){
        List<User> users = new ArrayList<>();
        try (Connection connection = ds.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select first_name, last_name, phone from user");
            while (rs.next()){
                String firstName = rs.getString(1);
                String lastName = rs.getString(2);
                String phone = rs.getString(3);
                users.add(new User(firstName, lastName, phone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
