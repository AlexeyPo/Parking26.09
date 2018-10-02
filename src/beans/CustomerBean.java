package beans;

import java.util.List;

public class CustomerBean {
    List<Customer> customers;

    public CustomerBean(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}