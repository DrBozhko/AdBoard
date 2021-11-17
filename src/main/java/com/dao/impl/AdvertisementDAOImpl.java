package com.dao.impl;

import com.dao.AdvertisementDAO;
import com.domain.Advertisement;
import com.repository.AdvertisementRepository;
import com.repository.MailRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AdvertisementDAOImpl implements AdvertisementDAO {

    AdvertisementRepository repository;

    @Override
    public void deleteByAuthorId(int id) {
        repository.deleteAllByAuthorId(id);
    }

    @Override
    public List<Advertisement> findFromDifferentRubrics(List<Integer> ids) {
        return repository.findAllByRubricIsIn(ids);
    }

    @Override
    public List<Advertisement> findByDate(LocalDate localDate) {
        return repository.findAllByPublication(localDate);
    }

    @Override
    public List<Advertisement> findByText(String text) {
        return repository.findAllByNameContains(text);
    }

    @Override
    public List<Advertisement> findAllByAuthor(int id) {
        return repository.findAllByAuthorId(id);
    }

    @Override
    public void save(Advertisement advertisement) {

        repository.save(advertisement);
    }

    @Override
    public void update(Advertisement advertisement) {
        repository.save(advertisement);
    }

    @Override
    public Advertisement findById(int id) {
        return repository.findById(id).get();

    }

    @Override
    public void deleteById(int id) {
       repository.deleteById(id);
    }
}
