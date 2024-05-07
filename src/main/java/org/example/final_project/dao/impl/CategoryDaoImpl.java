package org.example.final_project.dao.impl;

import org.example.final_project.dao.CrudDao;
import org.example.final_project.domain.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.SQLException;




@Repository
@Transactional
public class CategoryDaoImpl implements CrudDao<Category> {
    @PersistenceContext
     EntityManager em;
    @Override
    public void update(Category category) throws SQLException {
        Category category1 = em.merge(category);
        em.persist(category1);
        em.close();


    }
    @Override
    public void add(Category category) {
        em.persist(category);

    }
    @Override
    public Category findById(int id) throws SQLException {
        Category category = em.find(Category.class, id);
        em.close();
        return category;

    }
    @Override
    public void removeById(int id) throws SQLException {
        Query query = em.createQuery("DELETE FROM Category c WHERE c.id =: c_id");
        query.setParameter("c_id", id);
        query.executeUpdate();
    }
}
