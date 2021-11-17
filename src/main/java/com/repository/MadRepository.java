package com.repository;

import com.domain.MatchingAd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MadRepository extends JpaRepository<MatchingAd, Integer> {

}
