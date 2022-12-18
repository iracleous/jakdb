package gr.codehub.jakdb.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import gr.codehub.jakdb.model.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CustomerDto {
    private long id;
    private String name;
    private String emailAddress;
    private int birthYear;
    @JsonSerialize(using = gr.codehub.jakdb.serializers.LocalDateTimeSerializer.class)
    @JsonDeserialize(using = gr.codehub.jakdb.serializers.LocalDateTimeDeserializer.class)
    private LocalDateTime registrationDate;

    public CustomerDto(Customer customer) {
        if (customer != null) {
            id = customer.getId();
            name = customer.getName();
            emailAddress = customer.getEmailAddress();
            birthYear = customer.getBirthYear();
            registrationDate = customer.getRegistrationDate();
        }
    }

    public Customer asCustomer() {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setEmailAddress(emailAddress);
        customer.setBirthYear(birthYear);
        customer.setRegistrationDate(registrationDate);
        return customer;
    }
}