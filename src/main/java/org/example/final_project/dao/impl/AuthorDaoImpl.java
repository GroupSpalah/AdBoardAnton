package org.example.final_project.dao.impl;


import org.example.final_project.dao.CrudDao;
import org.example.final_project.domain.Author;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.SQLException;
@Repository
@Transactional
public class AuthorDaoImpl implements CrudDao<Author> {

    @PersistenceContext
    EntityManager em;

    @Override
    public void  update(Author author) throws SQLException {
        Author author1 = em.merge(author);
        em.persist(author1);
    }

    @Override
    public void add(Author author) {
        em.persist(author);
    }



    @Override
    public Author findById(int id) throws SQLException {

        Author author = em.find(Author.class, id);
        return author;

    }

    @Override
    public void removeById(int id) throws SQLException {
        Query query = em.createQuery("DELETE FROM Author c WHERE c.id =: c_id");
        query.setParameter("c_id", id);
        query.executeUpdate();



    }
}
