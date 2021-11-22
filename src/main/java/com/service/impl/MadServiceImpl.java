package com.service.impl;

import com.domain.MatchingAd;
import com.repository.CRUDRepository;
import com.service.CrudService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class MadServiceImpl implements CrudService<MatchingAd> {

    CRUDRepository<MatchingAd> repository;

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
