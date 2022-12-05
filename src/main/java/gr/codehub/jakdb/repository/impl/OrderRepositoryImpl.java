package gr.codehub.jakdb.repository.impl;

import gr.codehub.jakdb.model.Order;
import gr.codehub.jakdb.repository.OrderRepository;

public class OrderRepositoryImpl  extends RepositoryImpl<Order, Long> implements OrderRepository{

    @Override
    public Class<Order> getClassType() {
        return Order.class;
    }

    @Override
    public String getClassName() {
        return Order.class.getSimpleName();
    }
}