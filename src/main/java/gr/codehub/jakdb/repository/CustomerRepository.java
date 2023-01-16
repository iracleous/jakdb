package gr.codehub.jakdb.repository;

import gr.codehub.jakdb.model.Customer;
import gr.codehub.jakdb.model.Order;

import java.util.List;

public interface CustomerRepository extends Repository<Customer, Long> {

    List<Order> findOrdersByCustomer(long customerId);

}
