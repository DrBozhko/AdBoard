package com.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository<T> extends JpaRepository<T, Integer> {

    @EntityGraph(attributePaths = {"phones"})
    List<T> findAll();
}
