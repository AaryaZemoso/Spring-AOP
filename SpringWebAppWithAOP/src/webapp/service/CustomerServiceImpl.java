package webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webapp.dao.CustomerDAO;
import webapp.entity.Customer;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer cust)
    {
        customerDAO.saveCustomer(cust);
    }

    @Override
    @Transactional
    public Customer getCustomer(int id)
    {
        return customerDAO.getCustomer(id);
    }

    @Override
    @Transactional
    public void delete(int id){
        customerDAO.delete(id);
    }
}
