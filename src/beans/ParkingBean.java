package beans;

import java.util.List;

public class ParkingBean {

    private List<Parking> parkings;

    public ParkingBean(List<Parking> parkings) {
        this.parkings = parkings;
    }

    public List<Parking> getParkings() {
        return parkings;
    }

    public void setParkings(List<Parking> parkings) {
        this.parkings = parkings;
    }
}
