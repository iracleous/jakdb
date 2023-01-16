package gr.codehub.jakdb.repository.impl;

import gr.codehub.jakdb.model.Customer;
import gr.codehub.jakdb.model.Order;
import gr.codehub.jakdb.repository.CustomerRepository;

import java.util.List;

public class CustomerRepositoryImpl extends RepositoryImpl<Customer, Long> implements CustomerRepository {

    @Override
    public Class<Customer> getClassType() {
        return Customer.class;
    }

    @Override
    public String getClassName() {
        return Customer.class.getSimpleName();
    }

    @Override
    public List<Order> findOrdersByCustomer(long customerId) {

        return em.createQuery("SElect o from Customer c join Order o where c.id=:id")
                .setParameter("id", customerId).getResultList();
    }
}
