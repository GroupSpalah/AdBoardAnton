package org.example.final_project.service.impl;


import org.example.final_project.dao.CrudDao;
import org.example.final_project.dao.impl.AuthorDaoImpl;

import org.example.final_project.domain.Author;

import org.example.final_project.service.CrudService;

import java.sql.SQLException;

public class AuthorServiceImpl implements CrudService<Author> {
    CrudDao<Author> dao;

    public AuthorServiceImpl() {
        dao = new AuthorDaoImpl();
    }

    @Override
    public Author update(Author author) throws SQLException {
        return dao.update(author);
    }

    @Override
    public void add(Author author) {
dao.add(author);
    }

    @Override
    public Author findById(int id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void removeById(int id) throws SQLException {
dao.removeById(id);
    }
}
