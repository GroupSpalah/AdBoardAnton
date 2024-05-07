package org.example.final_project.service.impl;

import lombok.AllArgsConstructor;
import org.example.final_project.dao.CrudDao;
import org.example.final_project.domain.MatchingAd;
import org.example.final_project.service.CrudService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
@Service
@AllArgsConstructor
public class MatchAdServiceImpl implements CrudService<MatchingAd> {

    CrudDao<MatchingAd> dao;
    @Override
    public void update(MatchingAd matchingAd) throws SQLException {
         dao.update(matchingAd);
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
