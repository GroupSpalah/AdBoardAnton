package org.example.final_project.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.final_project.dao.AuthorDao;
import org.example.final_project.domain.Advertisement;
import org.example.final_project.domain.Author;

import java.sql.SQLException;

public class AuthorDaoImpl implements AuthorDao {
    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("antonio");
    @Override
    public Author update(Author author) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        author.setName("Ivan");


        Author author1 = em.merge(author);
        em.persist(author1);
        System.out.println(author1);
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
        System.out.println(author);
        transaction.commit();
        em.close();

        return author;

    }
}
