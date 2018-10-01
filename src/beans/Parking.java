package beans;

public class Parking {
    private int id;
    private String parkingAddress;
    private int quantityOfParking;
    private int quantityOfOccupiedParking;
    private int ratePerDay;

    public Parking(int id, String parkingAddress, int quantityOfParking, int quantityOfOccupiedParking, int ratePerDay) {
        this.id = id;
        this.parkingAddress = parkingAddress;
        this.quantityOfParking = quantityOfParking;
        this.quantityOfOccupiedParking = quantityOfOccupiedParking;
        this.ratePerDay = ratePerDay;
    }

    public Parking(String parkingAddress, int quantityOfParking, int quantityOfOccupiedParking, int ratePerDay) {
        this.parkingAddress = parkingAddress;
        this.quantityOfParking = quantityOfParking;
        this.quantityOfOccupiedParking = quantityOfOccupiedParking;
        this.ratePerDay = ratePerDay;
    }

    public Parking() {
    }

    public Parking(String parkingAddress) {
        this.parkingAddress = parkingAddress;
    }

    public Parking(int quantityOfOccupiedParking) {
        this.quantityOfOccupiedParking=quantityOfOccupiedParking;
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

    public int getQuantityOfOccupiedParking() {
        return quantityOfOccupiedParking;
    }

    public void setQuantityOfParking(int quantityOfParking) {
        this.quantityOfParking = quantityOfParking;
    }

    public void setQuantityOfOccupiedParking(int quantityOfOccupiedParking) {
        this.quantityOfOccupiedParking = quantityOfOccupiedParking;
    }

    public int getRatePerDay() {
        return ratePerDay;
    }

    public void setRatePerDay(int ratePerDay) {
        this.ratePerDay = ratePerDay;
    }
}
