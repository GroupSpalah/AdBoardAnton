package org.example.final_project.service;

import org.example.final_project.domain.Advertisement;
import org.example.final_project.domain.Category;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface AdvertisementService extends CrudService<Advertisement> {
    public List<Advertisement> getByCategory(Category category) throws SQLException;
    public List<Advertisement> showByAuthor(String name) throws SQLException;
    public List<Advertisement> showByKeyWord(String keyWord) throws SQLException;
    public List<Advertisement> showByDate(LocalDate date) throws SQLException;
}
