package org.example.final_project.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.final_project.dao.CategoryDao;
import org.example.final_project.domain.Advertisement;
import org.example.final_project.domain.Category;

import java.sql.SQLException;

public class CategoryDaoImpl implements CategoryDao {
    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("antonio");
    @Override
    public Category update(Category category) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        category.setName("Computers");


        Category category1 = em.merge(category);
        em.persist(category1);
        System.out.println(category1);
        transaction.commit();
        em.close();
        return category1;

    }

    @Override
    public void add(Category category) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(category);
        transaction.commit();
    }



    @Override
    public Category findById(int id) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Category category = em.find(Category.class, id);
        System.out.println(category);
        transaction.commit();
        em.close();
        return category;

    }
}
