package org.example.final_project.dao.impl;

import jakarta.persistence.*;
import org.example.final_project.dao.CrudDao;
import org.example.final_project.domain.MatchingAd;

import java.sql.SQLException;

public class MatchAdDaoImpl implements CrudDao<MatchingAd>  {
    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("antonio");

    @Override
    public MatchingAd update(MatchingAd matchingAd) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        MatchingAd matchingAd1 = em.merge(matchingAd);
        em.persist(matchingAd1);
        transaction.commit();
        em.close();
        return matchingAd1;

    }

    @Override
    public void add(MatchingAd matchingAd) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(matchingAd);
        transaction.commit();
    }

    @Override
    public MatchingAd findById(int id) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        MatchingAd matchingAd = em.find(MatchingAd.class, id);
        transaction.commit();
        em.close();
        return matchingAd;

    }

    @Override
    public void removeById(int id) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery("DELETE FROM MatchingAd m WHERE m.id =: m_id");
        query.setParameter("m_id", id);
        query.executeUpdate();
        transaction.commit();
        em.close();
    }
}
