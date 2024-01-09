package org.example.final_project.service.impl;

import org.example.final_project.dao.AdvertisementDao;
import org.example.final_project.dao.impl.AdvertisementDaoImpl;
import org.example.final_project.domain.Advertisement;
import org.example.final_project.service.AdvertisementService;

import java.sql.SQLException;

public class AdvertisementServiceImpl implements AdvertisementService {
    AdvertisementDao dao;

    public AdvertisementServiceImpl() {
        dao = new AdvertisementDaoImpl();
    };

    @Override
    public Advertisement update(Advertisement advertisement) throws SQLException {
        return advertisement;
    }

    @Override
    public void add(Advertisement advertisement) {
dao.add(advertisement);
    }

    @Override
    public Advertisement findById(int id) throws SQLException {
        return dao.findById(id);
    }
}




