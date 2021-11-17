package com.service.impl;

import com.dao.CrudDAO;
import com.domain.Author;
import com.domain.MatchingAd;
import com.service.CrudService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class MadServiceImpl implements CrudService<MatchingAd> {

    CrudDAO<MatchingAd> dao;

    @Override
    public void save(MatchingAd matchingAd) {
        dao.save(matchingAd);
    }

    @Override
    public void update(MatchingAd matchingAd) {
        dao.update(matchingAd);
    }

    @Override
    public MatchingAd findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }
}
