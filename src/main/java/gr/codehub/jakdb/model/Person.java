package gr.codehub.jakdb.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class Person extends BaseEntity {

    private String name;
    @Column(unique = true)
    private String emailAddress;
    private int birthYear;

    private LocalDateTime registrationDate;
}
