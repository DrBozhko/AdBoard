package com.dao;

import com.domain.Advertisement;

import java.time.LocalDate;
import java.util.List;

public interface AdvertisementDAO extends CrudDAO<Advertisement> {
    List<Advertisement> findAllByAuthor(int id);

    void deleteByAuthorId(int id);
    List<Advertisement> findFromDifferentRubrics(List<Integer> ids);
    List<Advertisement> findByDate(LocalDate localDate);
    List<Advertisement> findByText(String text);

}
