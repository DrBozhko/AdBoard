package com.service.impl;

import com.domain.Advertisement;
import com.repository.AdvertisementRepository;
import com.service.AdvertisementService;
import com.service.MailService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class AdvertisementServiceImpl implements AdvertisementService {

    AdvertisementRepository repository;
    MailService MAIL_SERVICE;

    @Override
    public void save(Advertisement advertisement) {
        repository.save(advertisement);
        MAIL_SERVICE.sendMails(advertisement);
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

    @Override
    public void deleteAdvertisementByAuthor(int authorId) {
      repository.deleteAllByAuthorId(authorId);
    }

    @Override
    public List<Advertisement> findFromDifferentRubrics(List<Integer> ids) {
        return repository.findAllByRubricIsIn(ids);
    }

    @Override
    public List<Advertisement> findByAuthorId(int id) {
        return repository.findAllByAuthorId(id);
    }

    @Override
    public List<Advertisement> findByDate(LocalDate localDate) {
        return repository.findAllByPublication(localDate);
    }

    @Override
    public List<Advertisement> findByText(String text) {
        return repository.findAllByNameContains(text);
    }


}
