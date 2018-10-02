package beans;

import java.time.LocalDateTime;

public class FactOfParking {
    private int id;
    private LocalDateTime startTime;
    private LocalDateTime finish;

    private Customer customer;
    private Parking parking;
    private User user;

    public FactOfParking(int id, LocalDateTime startTime, LocalDateTime finish) {
        this.id = id;
        this.startTime = startTime;
        this.finish = finish;
    }

    public FactOfParking() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}