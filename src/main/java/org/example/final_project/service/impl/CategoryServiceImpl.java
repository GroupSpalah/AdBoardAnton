package org.example.final_project.service.impl;


import lombok.AllArgsConstructor;
import org.example.final_project.dao.CrudDao;
import org.example.final_project.domain.Category;
import org.example.final_project.service.CrudService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CrudService<Category> {
    CrudDao<Category> dao;
    @Override
    public void update(Category category) throws SQLException {
         dao.update(category);
    }

    @Override
    public void add(Category category) {
           dao.add(category);
    }

    @Override
    public Category findById(int id) throws SQLException {
    return   dao.findById(id);
    }

    @Override
    public void removeById(int id) throws SQLException {
        dao.removeById(id);
    }
}
