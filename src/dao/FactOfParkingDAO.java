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
                    "WHERE start_time IS NOT null AND finish IS NULL AND customer_id IN (SELECT id FROM customer WHERE car_number=?)");
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

    public int countDaysOnParking(String carNumber, int id) {
        int daysOnParking = 0;
        try (Connection connection = ds.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT (DATEDIFF(CURRENT_TIMESTAMP(), start_time))" +
                    " AS days FROM fact_of_parking INNER JOIN user u ON fact_of_parking.user_id = u.id" +
                    " INNER JOIN customer c ON fact_of_parking.customer_id = c.id INNER JOIN parkings p ON" +
                    " u.parking_id = p.id WHERE p.id IN (SELECT parking_id FROM user WHERE id=?) AND customer_id IN " +
                    "(SELECT c.id FROM customer WHERE c.car_number=?)");
            statement.setInt(1, id);
            statement.setString(2, carNumber);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                daysOnParking = resultSet.getInt(1);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return daysOnParking;
        }
        return daysOnParking;
    }

    public int findRate(String carNumber) {
        int rate = 0;
        try (Connection connection = ds.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT rate_per_day FROM " +
                    "parkings INNER JOIN user u ON parkings.id = u.parking_id INNER JOIN fact_of_parking fop ON " +
                    "u.id = fop.user_id INNER JOIN customer c on fop.customer_id = c.id WHERE  car_number=?");
            statement.setString(1, carNumber);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                rate = rs.getInt(1);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return rate;
        }
        return rate;
    }

    public void makePayment(int daysOnParking, int rate, String carNumber) {
        int payment;
        if (daysOnParking == 0) {
            payment = rate;
        } else {
            payment = daysOnParking * rate;
        }
        try (Connection connection = ds.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE customer SET payment=? WHERE car_number=?");
            statement.setInt(1, payment);
            statement.setString(2, carNumber);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
