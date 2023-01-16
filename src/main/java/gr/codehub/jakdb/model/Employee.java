package gr.codehub.jakdb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Employee extends Person {

    @OneToMany(mappedBy = "employee")
    private List<Order> orders;
    
    
    @ManyToOne
    private Employee manager;
    
//    @OneToMany(mappedBy = "manager")
//    private List<Employee> subordinates;
}
