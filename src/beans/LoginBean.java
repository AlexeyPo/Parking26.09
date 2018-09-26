package beans;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Stateless
public class LoginBean {
    @Resource(mappedName = "jdbc/parking")
    DataSource ds;

    public User find(String login, String password) {
        try (Connection connection = ds.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("select * from user where login = ? AND password = ?");
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return new User(resultSet.getInt(1), login, password, resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6), resultSet.getBoolean(7));
            } else {
                return new User(0, login, password);
            }
        } catch (SQLException e) {
            return new User(0, login, password);
        }
    }
}
