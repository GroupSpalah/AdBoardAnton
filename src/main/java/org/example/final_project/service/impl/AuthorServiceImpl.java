package org.example.final_project.service.impl;


import lombok.AllArgsConstructor;
import org.example.final_project.dao.CrudDao;
import org.example.final_project.domain.Author;
import org.example.final_project.service.CrudService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
@Service
@AllArgsConstructor
public class AuthorServiceImpl implements CrudService<Author> {
    CrudDao<Author> dao;
    @Override
    public void update(Author author) throws SQLException {
        dao.update(author);
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
