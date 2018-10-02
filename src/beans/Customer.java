package beans;


public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String make;
    private String model;
    private String carNumber;
    private int payment;

    public Customer(int id, String firstName, String lastName, String phone, String make, String model, String carNumber, int payment) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.make = make;
        this.model = model;
        this.carNumber = carNumber;
        this.payment = payment;
    }

    public Customer(String firstName, String lastName, String phone, String make, String model, String carNumber, int payment) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.phone=phone;
        this.make=make;
        this.model=model;
        this.carNumber=carNumber;
        this.payment = payment;
    }

    public Customer() {
    }

    public Customer(String firstName, String lastName, String phone, String make, String model, String carNumber) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.phone=phone;
        this.make=make;
        this.model=model;
        this.carNumber=carNumber;
    }

    public Customer(String carNumber, int payment) {
        this.carNumber=carNumber;
        this.payment=payment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }
}