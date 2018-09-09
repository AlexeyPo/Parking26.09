package beans;

public class Car {
    private int id;
    private String make;
    private String model;
    private String carNumber;

    private Customer customer;

    public Car(int id, String make, String model, String carNumber) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.carNumber = carNumber;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
