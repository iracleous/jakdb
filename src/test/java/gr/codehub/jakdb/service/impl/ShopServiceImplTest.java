package gr.codehub.jakdb.service.impl;

import gr.codehub.jakdb.dto.CustomerDto;
import gr.codehub.jakdb.model.Customer;
import gr.codehub.jakdb.repository.CustomerRepository;
import gr.codehub.jakdb.service.ShopService;

import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


 //how to inject
class ShopServiceImplTest {


    @Inject
    private CustomerRepository customerRepository;

    @Inject
    private ShopService service;

    @Test
    void create() {

        CustomerDto dto = new CustomerDto();
        dto.setName("Iracleous");

        // service has not been initialiazed error

        CustomerDto dtoResult = service.create(dto);

        long createdId = dtoResult.getId();

        Customer customer = customerRepository.read(createdId);

        assertEquals(dto.getName(), customer.getName());

    }
}