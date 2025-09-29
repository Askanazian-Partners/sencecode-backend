package am.vector.payroll.api.v1.service;

import java.util.Optional;

public interface BaseService<T> {

    Optional<T> findById(String id);

    Iterable<T> findAll();

    T save(T object);

    Iterable<T> saveAll(Iterable<T> objects);

    boolean existsById(String id);

    Iterable<T> findAllById(Iterable<String> id);

    long count();

    void deleteById(String id);

    void delete(T object);

    void deleteAll(Iterable<T> objects);

    void deleteAll();
}
