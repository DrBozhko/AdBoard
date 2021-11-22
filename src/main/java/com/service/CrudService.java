package com.service;

import com.domain.BaseDomain;

public interface CrudService<T extends BaseDomain> {
    void save(T t);
    void update(T t);
    T findById(int id);
    void deleteById(int id);
}
