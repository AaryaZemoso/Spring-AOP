package webapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import webapp.entity.Customer;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        Session session = sessionFactory.getCurrentSession();

        Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);

        List<Customer> customers = query.getResultList();

        return customers;
    }

    public void saveCustomer(Customer cust)
    {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(   cust);
    }

    public void delete(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Customer cust = session.get(Customer.class, id);
        session.delete(cust);
    }


    public Customer getCustomer(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Customer cust = session.get(Customer.class, id);
        return cust;
    }

}
