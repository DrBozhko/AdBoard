package com.dao;

public interface CrudDAO<T> {
    default void save(T t) {

    }
    void update(T t);
    T findById(int id);
    void deleteById(int id);
}
