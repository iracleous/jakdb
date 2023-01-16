package gr.codehub.jakdb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Product extends BaseEntity {

    private String name;
    private BigDecimal price;
    private LocalDate fistLaunchDate;
    private ProductCategory productCategory;
    @ManyToMany(mappedBy = "products")
    private List<Supplier> suppliers;
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;
}
