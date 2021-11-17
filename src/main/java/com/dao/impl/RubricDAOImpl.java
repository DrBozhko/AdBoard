package com.dao.impl;

import com.dao.CrudDAO;
import com.domain.Rubric;
import com.repository.RubricRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RubricDAOImpl implements CrudDAO<Rubric> {

    RubricRepository repository;

    @Override
    public void save(Rubric rubric) {
        repository.save(rubric);
    }

    @Override
    public void update(Rubric rubric) {
        repository.save(rubric);
    }

    @Override
    public Rubric findById(int id) {
        return repository.findById(id).get();

    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
