package gr.codehub.jakdb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class Customer extends Person {
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
    @OneToMany(mappedBy = "customer")
    private List<Contract> contracts;
}