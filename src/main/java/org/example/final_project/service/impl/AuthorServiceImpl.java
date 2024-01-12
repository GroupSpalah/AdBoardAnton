package org.example.final_project.service.impl;

import org.example.final_project.dao.AuthorDao;
import org.example.final_project.dao.impl.AuthorDaoImpl;
import org.example.final_project.domain.Advertisement;
import org.example.final_project.domain.Author;
import org.example.final_project.service.AuthorService;

import java.sql.SQLException;

public class AuthorServiceImpl implements AuthorService {
    AuthorDao dao;

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
}
