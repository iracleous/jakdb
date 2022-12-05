package gr.codehub.jakdb.repository;

import gr.codehub.jakdb.model.AppUser;

public interface AppUserRepository extends Repository<AppUser, Long>{

    String checkRole(String username, String password);
}
