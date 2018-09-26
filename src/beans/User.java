package beans;

public class User {
    private int id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private boolean active;

    private Parking parking;

    public User(int id, String login, String password, String phone, String firstName, String lastName, boolean active) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
    }

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

//    public User(int id, String login, String password, String firstName) {
//        this.id = id;
//        this.login = login;
//        this.password = password;
//        this.firstName = firstName;
//    }

    public User(String firstName, String lastName, String phone) {//list of employee
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }
}
