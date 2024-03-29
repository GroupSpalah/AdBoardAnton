package org.example.final_project.dao.impl;

import jakarta.persistence.*;
import org.example.final_project.dao.AdvertisementDao;
import org.example.final_project.domain.Advertisement;
import org.example.final_project.domain.Category;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class AdvertisementDaoImpl implements AdvertisementDao {
    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("antonio");
    @Override
    public Advertisement update(Advertisement advertisement) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Advertisement advertisement1 = em.merge(advertisement);
        em.persist(advertisement1);
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

    @Override
    public void removeById(int id) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery("DELETE FROM Advertisement c WHERE c.id =: c_id");
        query.setParameter("c_id", id);
        query.executeUpdate();
        transaction.commit();
       em.close();
    }

    @Override
    public List<Advertisement> getByCategory(Category category) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Advertisement> query =
                em.createQuery("SELECT a FROM Advertisement a WHERE a.category.name = :category_name",
                        Advertisement.class);

        query.setParameter("category_name", category);
        List<Advertisement> advertisement = query.getResultList();
        System.out.println(advertisement);
        transaction.commit();
        return advertisement;
    }

    @Override
    public List<Advertisement> showByAuthor(String name) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Advertisement> query =
                em.createQuery("SELECT a FROM Advertisement a WHERE a.author.name = :author_name ",
                        Advertisement.class);
        query.setParameter("author_name", name);
        List<Advertisement> advertisement = query.getResultList();
        System.out.println(advertisement);
        transaction.commit();
        return advertisement;
    }

    @Override
    public List<Advertisement> showByKeyWord(String keyWord) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Advertisement> query =
                em.createQuery("SELECT a FROM Advertisement a WHERE a.advert_text LIKE " +
                                "CONCAT('%', :keyword, '%')",
                Advertisement.class);
        query.setParameter("keyword", keyWord);
        List<Advertisement> advertisement = query.getResultList();
        System.out.println(advertisement);
        transaction.commit();
        return advertisement;
    }

    @Override
    public List<Advertisement> showByDate(LocalDate date) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Advertisement> query =
                em.createQuery("SELECT a FROM Advertisement a WHERE a.date = :a_date ",
        Advertisement.class);
        query.setParameter("a_date",date);
        List<Advertisement> advertisement = query.getResultList();
        System.out.println(advertisement);
        transaction.commit();
        return advertisement;
    }
}
