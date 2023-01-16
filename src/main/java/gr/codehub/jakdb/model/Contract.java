package gr.codehub.jakdb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Contract extends BaseEntity {

    private LocalDateTime signDate;
    @ManyToOne
    private Customer customer;
}
