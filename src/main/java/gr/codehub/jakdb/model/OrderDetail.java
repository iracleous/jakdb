package gr.codehub.jakdb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class OrderDetail extends BaseEntity {

    private int quantity;
    private BigDecimal finalPrice;
    @ManyToOne
    private Order order;
    @ManyToOne
    private Product product;
}
