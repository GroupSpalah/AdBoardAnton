package org.example.final_project.dao.impl;

import org.example.final_project.dao.CrudDao;
import org.example.final_project.domain.MatchingAd;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.SQLException;

@Repository
@Transactional
public class MatchAdDaoImpl implements CrudDao<MatchingAd> {
    @PersistenceContext
    EntityManager em;

    @Override
    public void update(MatchingAd matchingAd) throws SQLException {
        MatchingAd matchingAd1 = em.merge(matchingAd);
        em.persist(matchingAd1);
    }

    @Override
    public void add(MatchingAd matchingAd) {
        em.persist(matchingAd);
    }

    @Override
    public MatchingAd findById(int id) throws SQLException {
        return em.find(MatchingAd.class, id);
    }

    @Override
    public void removeById(int id) throws SQLException {
        Query query = em.createQuery("DELETE FROM MatchingAd m WHERE m.id =: m_id");
        query.setParameter("m_id", id);
        query.executeUpdate();

    }
}
