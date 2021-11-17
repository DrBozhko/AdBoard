package com.service;

import com.domain.Advertisement;

import java.time.LocalDate;
import java.util.List;

public interface AdvertisementService extends CrudService<Advertisement>{
    void deleteAdvertisementByAuthor(int id);
    List<Advertisement> findFromDifferentRubrics(List<Integer> ids);
    List<Advertisement> findByAuthorId(int id);
    List<Advertisement> findByDate(LocalDate localDate);
    List<Advertisement> findByText(String text);
}
