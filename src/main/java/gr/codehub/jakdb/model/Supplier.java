package gr.codehub.jakdb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Supplier extends Person {

    @ManyToMany  (fetch = FetchType.LAZY)
    private List<Product> products;
}
