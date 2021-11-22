package com.repository;

import com.domain.BaseDomain;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CRUDRepository<T extends BaseDomain> extends JpaRepository<T, Integer> {

}
