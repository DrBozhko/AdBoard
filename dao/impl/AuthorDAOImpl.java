package com.dao.impl;

import com.dao.CrudDAO;
import com.domain.Author;
import com.domain.Author_;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.*;

@Repository
@Transactional
public class AuthorDAOImpl implements CrudDAO<Author> {

    @PersistenceContext
    EntityManager em;

    @Override
    public void save(Author author) {
        em.persist(author);
    }

    @Override
    public void update(Author author) {
        Author author1 = em.merge(author);

        em.persist(author1);
    }

    @Override
    public Author findById(int id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Author> query = builder.createQuery(Author.class);

        Root<Author> from = query.from(Author.class);

        Path<Integer> pathId = from.get(Author_.id);

        query.where(builder.equal(pathId, id));

        query.select(from);

        TypedQuery<Author> query1 = em.createQuery(query);

        return query1.getSingleResult();

    }

    @Override
    public void deleteById(int id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();


        CriteriaDelete<Author> criteriaDelete = builder.createCriteriaDelete(Author.class);
        Root<Author> from = criteriaDelete.from(Author.class);

        Path<Integer> integerPath = from.get(Author_.id);

        criteriaDelete.where(builder.equal(integerPath, id));

        Query query = em.createQuery(criteriaDelete);
        query.executeUpdate();

    }
}
