package com.dao.impl;

import com.dao.CrudDAO;
import com.domain.Author;
import com.domain.Rubric;
import com.repository.AuthorRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
@Transactional
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthorDAOImpl implements CrudDAO<Author> {

    AuthorRepository repository;

    @Override
    public void save(Author author) {
        repository.save(author);
    }

    @Override
    public void update(Author author) {
        repository.save(author);
    }

    @Override
    public Author findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
