package gr.codehub.jakdb.repository.impl;

import gr.codehub.jakdb.model.Customer;
import gr.codehub.jakdb.repository.CustomerRepository;

public class CustomerRepositoryImpl extends RepositoryImpl<Customer, Long> implements CustomerRepository {

    @Override
    public Class<Customer> getClassType() {
        return Customer.class;
    }

    @Override
    public String getClassName() {
        return Customer.class.getSimpleName();
    }
}