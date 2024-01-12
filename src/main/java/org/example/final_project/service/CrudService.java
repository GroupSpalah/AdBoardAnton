package org.example.final_project.service;



import java.sql.SQLException;

public interface CrudService <T>{
    public T update(T  t) throws SQLException;
    void add(T t);
    T findById(int id) throws SQLException;
    T removeById(int id) throws SQLException;
}
