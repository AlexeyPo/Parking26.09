package dao;

import beans.Parking;

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
public class ParkingDAO {

    @Resource(mappedName = "jdbc/parking")
    DataSource ds;

    public List<Parking> findAllParking(){
        List<Parking> parkings = new ArrayList<>();
        try (Connection connection = ds.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select parking_address, quantity_of_parking, rate_per_day, rate_per_month from parkings");
            while (rs.next()){
                String parkingAddress = rs.getString(1);
                int quantityOfParking = rs.getInt(2);
                int ratePerDay = rs.getInt(3);
                int ratePerMonth = rs.getInt(4);
                parkings.add(new Parking(parkingAddress, quantityOfParking, ratePerDay, ratePerMonth));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parkings;
    }
}
