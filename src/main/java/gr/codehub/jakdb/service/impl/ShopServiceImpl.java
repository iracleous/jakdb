package gr.codehub.jakdb.service.impl;

import gr.codehub.jakdb.dto.CustomerDto;
import gr.codehub.jakdb.model.Customer;
import gr.codehub.jakdb.repository.CustomerRepository;
import gr.codehub.jakdb.service.ShopService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;


public class ShopServiceImpl implements ShopService {
    @Inject
    private CustomerRepository customerRepository;
    @Override
    public CustomerDto create(CustomerDto customerDto) {
        Customer customer = customerDto.asCustomer();
        customerRepository.create(  customer);
        return new CustomerDto(customer);
    }

    @Override
    public CustomerDto read(long id) {

        return new CustomerDto(customerRepository.read(id));
    }

    @Override
    public List<CustomerDto> read() {
        return customerRepository.read().stream().map(CustomerDto::new).collect(Collectors.toList());
    }
}
