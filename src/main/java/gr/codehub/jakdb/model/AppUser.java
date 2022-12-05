package gr.codehub.jakdb.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class AppUser extends BaseEntity {
    private String username;
    private String password;
    private String role;
}
