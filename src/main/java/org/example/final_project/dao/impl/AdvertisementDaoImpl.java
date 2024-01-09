package org.example.final_project.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.final_project.dao.AdvertisementDao;
import org.example.final_project.domain.Advertisement;

import java.sql.SQLException;

public class AdvertisementDaoImpl implements AdvertisementDao {
    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("antonio");
    @Override
    public Advertisement update(Advertisement advertisement) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        advertisement.setName("Car");

        Advertisement advertisement1 = em.merge(advertisement);
        em.persist(advertisement1);
        System.out.println(advertisement1);
        transaction.commit();
        em.close();
        return advertisement1;
    }

    @Override
    public void add(Advertisement advertisement) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(advertisement);
        transaction.commit();
    }


    @Override
    public Advertisement findById(int id) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Advertisement advertisement = em.find(Advertisement.class, id);
        System.out.println(advertisement);
        transaction.commit();
        em.close();

        return advertisement;

    }
}
