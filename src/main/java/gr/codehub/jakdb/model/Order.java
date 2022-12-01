package gr.codehub.jakdb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Order extends BaseEntity {
    private LocalDateTime date;
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Employee employee;
}