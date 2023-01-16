package gr.codehub.jakdb.repository.impl;

import gr.codehub.jakdb.model.AppUser;
import gr.codehub.jakdb.repository.AppUserRepository;

public class AppUserRepositoryImpl extends RepositoryImpl<AppUser, Long> implements AppUserRepository {

    @Override
    public Class<AppUser> getClassType() {
        return AppUser.class;
    }

    @Override
    public String getClassName() {
        return AppUser.class.getSimpleName();
    }

    @Override
    public String checkRole(String username, String password) {
        try {
            return em.createQuery("select u.role from AppUser u where username=:u1 and password=:u2")
                    .setParameter("u1", username)
                    .setParameter("u2", password)
                    .getSingleResult()
                    .toString();
        } catch (Exception e) {
            return "";
        }
    }

    @Override
    public AppUser findByUserameAndPass(String username, String password) {
         return (AppUser)em.createQuery("select u from AppUser u where username=:u1 and password=:u2")
                    .setParameter("u1", username)
                    .setParameter("u2", password)
                    .getSingleResult();
    
    
    }
}
