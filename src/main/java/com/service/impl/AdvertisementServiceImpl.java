package com.service.impl;

import com.dao.AdvertisementDAO;
import com.domain.Advertisement;
import com.repository.AdvertisementRepository;
import com.service.AdvertisementService;
import com.service.MailService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class AdvertisementServiceImpl implements AdvertisementService {

    AdvertisementDAO DAO;
    MailService MAIL_SERVICE;
    AdvertisementRepository REPOSITORY;

    @Override
    public void save(Advertisement advertisement) {
        DAO.save(advertisement);
        MAIL_SERVICE.sendMails(advertisement);
    }

    @Override
    public void update(Advertisement advertisement) {
        DAO.update(advertisement);
    }

    @Override
    public Advertisement findById(int id) {
        return DAO.findById(id);
    }

    @Override
    public void deleteById(int id) {
        DAO.deleteById(id);
    }

    @Override
    public void deleteAdvertisementByAuthor(int authorId) {
      DAO.deleteByAuthorId(authorId);
    }

    @Override
    public List<Advertisement> findFromDifferentRubrics(List<Integer> ids) {
        return DAO.findFromDifferentRubrics(ids);
    }

    @Override
    public List<Advertisement> findByAuthorId(int id) {
        return DAO.findAllByAuthor(id);
    }

    @Override
    public List<Advertisement> findByDate(LocalDate localDate) {
        return DAO.findByDate(localDate);
    }

    @Override
    public List<Advertisement> findByText(String text) {
        return DAO.findByText(text);
    }

    // pagination
    public List<Advertisement> getSomePagination(int page, int size) {
        PageRequest pr = PageRequest.of(page, size, Sort.by("publication"));
        Page<Advertisement> personPage = REPOSITORY.findAll(pr);

        return personPage.toList();
    }
}
