package com.repository;

import com.domain.Author;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @EntityGraph(attributePaths = {"phones"})
    List<Author> findAll();

    Author findByName(String name);
}
