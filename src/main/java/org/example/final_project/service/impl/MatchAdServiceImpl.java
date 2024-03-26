package org.example.final_project.service.impl;

import org.example.final_project.dao.CrudDao;
import org.example.final_project.dao.impl.MatchAdDaoImpl;
import org.example.final_project.domain.MatchingAd;
import org.example.final_project.service.CrudService;

import java.sql.SQLException;

public class MatchAdServiceImpl implements CrudService<MatchingAd> {

    CrudDao<MatchingAd> dao;

    public MatchAdServiceImpl() {
        dao = new  MatchAdDaoImpl();
    }

    @Override
    public MatchingAd update(MatchingAd matchingAd) throws SQLException {
        return dao.update(matchingAd);
    }

    @Override
    public void add(MatchingAd matchingAd) {
          dao.add(matchingAd);
    }

    @Override
    public MatchingAd findById(int id) throws SQLException {
        return  dao.findById(id);
    }

    @Override
    public void removeById(int id) throws SQLException {
              dao.removeById(id);
    }
}
