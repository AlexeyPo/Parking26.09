package beans;

import java.util.List;

public class FactOfParkingBean {
    List<FactOfParking> factOfParkings;

    public FactOfParkingBean(List<FactOfParking> factOfParkings) {
        this.factOfParkings = factOfParkings;
    }

    public List<FactOfParking> getFactOfParkings() {
        return factOfParkings;
    }

    public void setFactOfParkings(List<FactOfParking> factOfParkings) {
        this.factOfParkings = factOfParkings;
    }
}