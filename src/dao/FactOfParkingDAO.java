package dao;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Stateless
public class FactOfParkingDAO {

    @Resource(mappedName = "jdbc/parking")
    DataSource ds;

    public void startParking(String carNumber, int id) {
        try (Connection connection = ds.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO fact_of_parking(start_time, " +
                    "user_id, customer_id) VALUES (CURRENT_TIMESTAMP(), ?, (SELECT id FROM customer " +
                    "WHERE car_number=?))");
            statement.setInt(1, id);
            statement.setString(2, carNumber);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void stopParking(String carNumber, int id) {
        try (Connection connection = ds.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE fact_of_parking SET finish=CURRENT_TIMESTAMP(), user_id=? " +
                    "WHERE start_time IS NOT null AND customer_id IN (SELECT id FROM customer WHERE car_number=?)");
            statement.setInt(1, id);
            statement.setString(2, carNumber);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isCarOnParking(String carNumber) {
        try (Connection connection = ds.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT customer_id FROM fact_of_parking WHERE" +
                    " start_time IS NOT null AND finish IS null AND customer_id IN (SELECT id FROM customer " +
                    "WHERE car_number = ?) GROUP BY customer_id");
            statement.setString(1, carNumber);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
