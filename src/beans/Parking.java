package beans;

public class Parking {
    private int id;
    private String parkingAddress;
    private int quantityOfParking;
    private int ratePerDay;
    private int getRatePerMonth;

    public Parking(int id, String parkingAddress, int quantityOfParking, int ratePerDay, int getRatePerMonth) {
        this.id = id;
        this.parkingAddress = parkingAddress;
        this.quantityOfParking = quantityOfParking;
        this.ratePerDay = ratePerDay;
        this.getRatePerMonth = getRatePerMonth;
    }

    public Parking() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParkingAddress() {
        return parkingAddress;
    }

    public void setParkingAddress(String parkingAddress) {
        this.parkingAddress = parkingAddress;
    }

    public int getQuantityOfParking() {
        return quantityOfParking;
    }

    public void setQuantityOfParking(int quantityOfParking) {
        this.quantityOfParking = quantityOfParking;
    }

    public int getRatePerDay() {
        return ratePerDay;
    }

    public void setRatePerDay(int ratePerDay) {
        this.ratePerDay = ratePerDay;
    }

    public int getGetRatePerMonth() {
        return getRatePerMonth;
    }

    public void setGetRatePerMonth(int getRatePerMonth) {
        this.getRatePerMonth = getRatePerMonth;
    }
}
