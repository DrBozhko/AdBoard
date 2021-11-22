package com.service.impl;

import com.domain.Rubric;
import com.repository.CRUDRepository;
import com.service.CrudService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class RubricServiceImpl implements CrudService<Rubric> {
    CRUDRepository<Rubric> dao;

    @Override
    public void save(Rubric rubric) {
        dao.save(rubric);
    }

    @Override
    public void update(Rubric rubric) {
        dao.save(rubric);
    }

    @Override
    public Rubric findById(int id) {
        return dao.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }
}
