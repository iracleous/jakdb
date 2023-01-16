package gr.codehub.jakdb.service;

import gr.codehub.jakdb.dto.CustomerDto;
import gr.codehub.jakdb.dto.OrderDto;

import java.util.List;

public interface ShopService {

    CustomerDto create(CustomerDto customerDto);

    CustomerDto read(long id);

    List<CustomerDto> read();

    OrderDto createOrder(long customerId);
}
