package gr.codehub.jakdb.repository.impl;

import gr.codehub.jakdb.repository.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

public abstract class RepositoryImpl<T, K> implements Repository<T, K> {

    @PersistenceContext(unitName = "Persistence")
    protected EntityManager em;

    public abstract Class<T> getClassType();

    public abstract String getClassName();

    @Override
    @Transactional
    public T create(T t) {
        em.persist(t);
        return t;
    }

    @Override
    public T read(K id) {
        return em.find(getClassType(), id);
    }

    @Override
    public List<T> read() {
        return em.createQuery("select c from " + getClassName() + " c").getResultList();
    }

    @Override
    @Transactional
    public boolean delete(K id) {
        T t = read(id);
        if (t == null) {
            return false;
        }
        em.remove(t);
        return true;
    }
}
