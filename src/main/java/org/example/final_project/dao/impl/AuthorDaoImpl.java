package org.example.final_project.dao.impl;

import jakarta.persistence.*;
import org.example.final_project.dao.CrudDao;
import org.example.final_project.domain.Author;
import org.springframework.stereotype.Repository;


import java.sql.SQLException;
@Repository
public class AuthorDaoImpl implements CrudDao<Author> {
    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("antonio");
    @Override
    public Author update(Author author) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Author author1 = em.merge(author);
        em.persist(author1);
        transaction.commit();
        em.close();
        return author1;

    }

    @Override
    public void add(Author author) {
            EntityManager em = FACTORY.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(author);
            transaction.commit();
        }



    @Override
    public Author findById(int id) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Author author = em.find(Author.class, id);
        transaction.commit();
        em.close();

        return author;

    }

    @Override
    public void removeById(int id) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery("DELETE FROM Author c WHERE c.id =: c_id");
        query.setParameter("c_id", id);
        query.executeUpdate();
        transaction.commit();
        em.close();


    }
}
