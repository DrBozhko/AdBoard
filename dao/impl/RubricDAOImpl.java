package com.dao.impl;

import com.dao.CrudDAO;
import com.domain.Rubric;
import com.domain.Rubric_;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

@Repository
@Transactional
public class RubricDAOImpl implements CrudDAO<Rubric> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Rubric rubric) {
        em.persist(rubric);
    }

    @Override
    public void update(Rubric rubric) {
        Rubric rb = em.merge(rubric);

        em.persist(rb);
    }

    @Override
    public Rubric findById(int id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Rubric> query = builder.createQuery(Rubric.class);

        Root<Rubric> from = query.from(Rubric.class);

        Path<Integer> integerPath = from.get(Rubric_.id);

        query.where(builder.equal(integerPath, id));

        query.select(from);

        TypedQuery<Rubric> query1 = em.createQuery(query);

        return query1.getSingleResult();

    }

    @Override
    public void deleteById(int id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();


        CriteriaDelete<Rubric> criteriaDelete = builder.createCriteriaDelete(Rubric.class);
        Root<Rubric> from = criteriaDelete.from(Rubric.class);

        Path<Integer> integerPath = from.get(Rubric_.id);

        criteriaDelete.where(builder.equal(integerPath, id));

        Query query = em.createQuery(criteriaDelete);
        query.executeUpdate();
    }

}
