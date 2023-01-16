package gr.codehub.jakdb.service.impl;

import gr.codehub.jakdb.dto.CustomerDto;
import gr.codehub.jakdb.model.Customer;
import gr.codehub.jakdb.repository.CustomerRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
//import org.mockito.ArgumentMatchers;
 
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ShopServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private ShopServiceImpl service;

    @Test
    void create() {

        CustomerDto dto = new CustomerDto();
        dto.setName("Iracleous");

        Customer custRet = new Customer();
        custRet.setName("Iracleous");
        custRet.setId(1l);

        when(customerRepository.create( 
                any(Customer.class))).thenReturn(custRet);

        // service has not been initialiazed error
        CustomerDto dtoResult = service.create(dto);

        long createdId = dtoResult.getId();

        assertEquals(dto.getName(), custRet.getName());
    }
}
