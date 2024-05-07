package org.example.final_project.service.impl;

import lombok.AllArgsConstructor;
import org.example.final_project.dao.AdvertisementDao;
import org.example.final_project.domain.Advertisement;
import org.example.final_project.service.AdvertisementService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
@Service
@AllArgsConstructor
public class AdvertisementServiceImpl implements AdvertisementService {
    AdvertisementDao dao;
    @Override
    public void update(Advertisement advertisement) throws SQLException {
        dao.update(advertisement);

    }

    @Override
    public void add(Advertisement advertisement) {
dao.add(advertisement);
    }

    @Override
    public Advertisement findById(int id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void removeById(int id) throws SQLException {
         dao.removeById(id);

    }

   @Override
    public List<Advertisement> getByCategory(String name) throws SQLException {
        return dao.getByCategory(name);
    }

    @Override
    public List<Advertisement> showByAuthor(String name) throws SQLException {
        return dao.showByAuthor(name);
    }

    @Override
    public List<Advertisement> showByKeyWord(String keyWord) throws SQLException {
        return dao.showByKeyWord(keyWord);
    }

    @Override
    public List<Advertisement> showByDate(LocalDate date) throws SQLException {
        return dao.showByDate(date);
    }
}




