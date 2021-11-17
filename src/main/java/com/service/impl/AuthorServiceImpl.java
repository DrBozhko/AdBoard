package com.service.impl;

import com.dao.CrudDAO;
import com.domain.Author;
import com.service.CrudService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class AuthorServiceImpl implements CrudService<Author> {

    CrudDAO<Author> dao;

    @Override
    public void save(Author author) {
        dao.save(author);
    }

    @Override
    public void update(Author author) {
        dao.update(author);
    }

    @Override
    public Author findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }
}
