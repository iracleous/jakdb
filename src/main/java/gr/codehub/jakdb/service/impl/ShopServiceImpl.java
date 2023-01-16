package gr.codehub.jakdb.service.impl;

import gr.codehub.jakdb.dto.CustomerDto;
import gr.codehub.jakdb.dto.OrderDto;
import gr.codehub.jakdb.model.AppUser;
import gr.codehub.jakdb.model.Customer;
import gr.codehub.jakdb.model.Order;
import gr.codehub.jakdb.repository.AppUserRepository;
import gr.codehub.jakdb.repository.CustomerRepository;
import gr.codehub.jakdb.repository.OrderRepository;
import gr.codehub.jakdb.service.ShopService;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class ShopServiceImpl implements ShopService {

    @Inject
    private CustomerRepository customerRepository;
    @Inject
    private OrderRepository orderRepository;

    @Inject
    private AppUserRepository appUserRepository;

    @Override
    public CustomerDto create(CustomerDto customerDto) {
        //data validations needed
        // business rules implementation
        Customer customer = customerDto.asCustomer();
        customerRepository.create(customer);
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

    @Override
    public OrderDto createOrder(long customerId) {
        Customer customer = customerRepository.read(customerId);
        if (customer == null) {
            return null;
        }
        Order order = new Order();
        order.setDate(LocalDateTime.now());
        order.setCustomer(customer);
        orderRepository.create(order);
        return new OrderDto(order);
    }

    @Override
    public AppUser getUser(String authorization) {

        final String encodedUserPassword = authorization.replaceFirst("Basic" + " ", "");
        //Decode username and password
        String usernameAndPassword = new String(Base64.getDecoder().decode(encodedUserPassword.getBytes()));

        //Split username and password tokens
        final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
        final String username = tokenizer.nextToken();
        final String password = tokenizer.nextToken();

        AppUser appUser = appUserRepository.findByUserameAndPass(username, password);

        return appUser;

    }
}
