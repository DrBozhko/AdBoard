package com.dao.impl;

import com.dao.AdvertisementDAO;
import com.domain.Advertisement;
import com.domain.Advertisement_;
import com.domain.Author;
import com.domain.Author_;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public class AdvertisementDAOImpl implements AdvertisementDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void deleteByAuthorId(int id) {

        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaDelete<Advertisement> cDelete = builder.createCriteriaDelete(Advertisement.class);
        Root<Advertisement> from = cDelete.from(Advertisement.class);

        Path<Author> authorPath = from.get(Advertisement_.author);

        cDelete.where(builder.equal(authorPath.get(Author_.id), id));

        Query query = em.createQuery(cDelete);
        query.executeUpdate();

    }

    @Override
    public List<Advertisement> findFromDifferentRubrics(List<Integer> ids) {
        TypedQuery<Advertisement> query =
                em.createQuery("FROM Advertisement ad " +
                        "JOIN FETCH Rubric r " +
                        "WHERE r.id IN (:ids)", Advertisement.class);

        query.setParameter("ids", ids);
        return query.getResultList();
    }

    @Override
    public List<Advertisement> findByAuthorId(int id) {
        TypedQuery<Advertisement> query =
                em.createQuery("FROM Advertisement ad " +
                        "JOIN FETCH Author at " +
                        "WHERE at.id = :aid", Advertisement.class);

        query.setParameter("aid", id);
        return query.getResultList();
    }

    @Override
    public List<Advertisement> findByDate(LocalDate localDate) {
        TypedQuery<Advertisement> query =
                em.createQuery("FROM Advertisement ad " +
                        "WHERE ad.publication = :adpublication", Advertisement.class);

        query.setParameter("adpublication", localDate);
        return query.getResultList();
    }

    @Override
    public List<Advertisement> findByText(String text) {
        TypedQuery<Advertisement> query =
                em.createQuery("FROM Advertisement ad " +
                        "WHERE ad.text LIKE CONCAT('%', phrase, '%')", Advertisement.class);

        query.setParameter("phrase", text);
        return query.getResultList();
    }

    @Override
    public List<Advertisement> findAllByAuthor(int id) {

        TypedQuery<Advertisement> query =
                em.createQuery("FROM Advertisement ad WHERE ad.author.id = :aId", Advertisement.class);

        query.setParameter("aId", id);

        return query.getResultList();

    }

    @Override
    public void save(Advertisement advertisement) {

        em.persist(advertisement);

    }

    @Override
    public void update(Advertisement advertisement) {
        Advertisement ad = em.merge(advertisement);

        em.persist(ad);

    }

    @Override
    public Advertisement findById(int id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Advertisement> query = builder.createQuery(Advertisement.class);

        Root<Advertisement> from = query.from(Advertisement.class);

        Path<Integer> integerPath = from.get(Advertisement_.id);

        query.where(builder.equal(integerPath, id));

        query.select(from);

        TypedQuery<Advertisement> query1 = em.createQuery(query);

        return query1.getSingleResult();

    }

    @Override
    public void deleteById(int id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();


        CriteriaDelete<Advertisement> criteriaDelete = builder.createCriteriaDelete(Advertisement.class);
        Root<Advertisement> root = criteriaDelete.from(Advertisement.class);

        Path<Integer> integerPath = root.get(Advertisement_.id);

        criteriaDelete.where(builder.equal(integerPath, id));

        Query query = em.createQuery(criteriaDelete);
        query.executeUpdate();

    }
}
