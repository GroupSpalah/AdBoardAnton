package org.example.final_project.service.impl;


import org.example.final_project.dao.CrudDao;
import org.example.final_project.dao.impl.CategoryDaoImpl;
import org.example.final_project.domain.Advertisement;
import org.example.final_project.domain.Category;

import org.example.final_project.service.CrudService;

import java.sql.SQLException;

public class CategoryServiceImpl implements CrudService<Category> {
    CrudDao<Category> dao;

    public CategoryServiceImpl() {
        dao = new CategoryDaoImpl();
    }

    @Override
    public Category update(Category category) throws SQLException {
        return dao.update(category);
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
