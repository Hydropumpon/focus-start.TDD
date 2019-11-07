package mocks.crud.example;

import java.util.List;

public interface Repository<K, T> {

    List<T> findAll();

    T findById(K id);

}
