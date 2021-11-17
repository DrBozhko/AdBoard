package com.repository;

import com.domain.Advertisement;
import com.domain.Rubric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Integer> {
    void deleteAllByAuthorId(int id);
    @Query("SELECT ad FROM Advertisement ad WHERE ad.rubric.id IN :ids")
    List<Advertisement> findAllByRubricIsIn(@Param("ids") List<Integer> ids);
    List<Advertisement> findAllByAuthorId(int id);
    List<Advertisement> findAllByPublication(LocalDate date);
    List<Advertisement> findAllByNameContains(String name);
}
