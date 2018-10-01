package dao;

import beans.Parking;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ParkingDAO {

    @Resource(mappedName = "jdbc/parking")
    DataSource ds;

    public List<Parking> findAllParking() {
        List<Parking> parkings = new ArrayList<>();
        try (Connection connection = ds.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT parking_address, quantity_of_parking, " +
                    "quantity_of_occupied_parking, rate_per_day FROM parkings");
            while (rs.next()) {
                String parkingAddress = rs.getString(1);
                int quantityOfParking = rs.getInt(2);
                int quantityOfOccupiedParking = rs.getInt(3);
                int ratePerDay = rs.getInt(4);
                parkings.add(new Parking(parkingAddress, quantityOfParking, quantityOfOccupiedParking, ratePerDay));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parkings;
    }

    public void countOccupiedParking(int id) {
        int quantityOfOccupiedParking = 0;
        try (Connection connection = ds.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT count(*) quantity FROM customer " +
                    "INNER JOIN fact_of_parking fop on customer.id = fop.customer_id INNER JOIN user u on " +
                    "fop.user_id = u.id INNER JOIN parkings p on u.parking_id = p.id WHERE p.id IN (SELECT parking_id " +
                    "FROM user WHERE id=?) AND finish IS NULL");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                quantityOfOccupiedParking = resultSet.getInt("quantity");
            }

            PreparedStatement statementUpd = connection.prepareStatement("UPDATE parkings SET quantity_of_occupied_parking = ? " +
                    "WHERE id IN (SELECT parking_id FROM user WHERE user.id=?)");
            statementUpd.setInt(1, quantityOfOccupiedParking);
            statementUpd.setInt(2, id);
            statementUpd.executeUpdate();
            statementUpd.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}