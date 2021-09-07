package webapp.dao;

import webapp.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();
    void saveCustomer(Customer cust);
    Customer getCustomer(int id);
    void delete(int id);
}
