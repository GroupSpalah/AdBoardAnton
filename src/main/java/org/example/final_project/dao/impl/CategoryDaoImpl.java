package org.example.final_project.dao.impl;

import jakarta.persistence.*;
import org.example.final_project.dao.CrudDao;
import org.example.final_project.domain.Category;

import java.sql.SQLException;

public class CategoryDaoImpl implements CrudDao<Category> {
    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("antonio");
    @Override
    public Category update(Category category) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Category category1 = em.merge(category);
        em.persist(category1);
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
        transaction.commit();
        em.close();
        return category;

    }
    @Override
    public void removeById(int id) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery("DELETE FROM Category c WHERE c.id =: c_id");
        query.setParameter("c_id", id);
        query.executeUpdate();
        transaction.commit();
        em.close();
    }
}
