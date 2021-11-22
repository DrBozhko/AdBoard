package com.service.impl;

import com.domain.Author;
import com.repository.CRUDRepository;
import com.service.CrudService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class AuthorServiceImpl implements CrudService<Author> {

    CRUDRepository<Author> repository;

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
