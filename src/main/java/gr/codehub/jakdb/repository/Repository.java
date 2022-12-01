package gr.codehub.jakdb.repository;

import java.util.List;

public interface Repository<T, K> {
    //CR(U)D
    T create(T t);
    T read(K id);
    List<T> read();
    boolean delete(K id);
}
