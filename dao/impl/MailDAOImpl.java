package com.dao.impl;

import com.dao.MailDAO;
import com.domain.Advertisement;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class MailDAOImpl implements MailDAO {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<String> findSuitableMails(Advertisement ad) {
        TypedQuery<String> query =
                em.createQuery(" SELECT em.name " +
                        "FROM MatchingAd mad " +
                        "JOIN FETCH mad.author au " +
                        "JOIN FETCH au.email em " +
                        "WHERE :price BETWEEN mad.priceFrom AND mad.priceTo " +
                        "AND mad.rubric.name = :category " +
                        "AND :title LIKE CONCAT('%', mad.title, '%')", String.class);

        query.setParameter("price", ad.getCost());
        query.setParameter("title", ad.getName());
        query.setParameter("category", ad.getRubric().getName());

        return query.getResultList();
    }


}

/*
* Mail <- Author <- Mad -> Rubric
*
* price between priceFrom, priceTo
* title = name
*
* Buy car
* Buy car new
* */
