package org.example.final_project.dao;

import java.sql.SQLException;

public interface CrudDao<T> {
    public void   update(T t) throws SQLException;

    void add(T t);

    T findById(int id) throws SQLException;

     void removeById(int id) throws SQLException;
}
