package com.dao.impl;

import com.dao.CrudDAO;
import com.domain.MatchingAd;
import com.domain.Rubric;
import com.repository.MadRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MatchingAdDAOImpl implements CrudDAO<MatchingAd> {

    MadRepository repository;

    @Override
    public void save(MatchingAd matchingAd) {
        repository.save(matchingAd);
    }

    @Override
    public void update(MatchingAd matchingAd) {
        repository.save(matchingAd);
    }

    @Override
    public MatchingAd findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
