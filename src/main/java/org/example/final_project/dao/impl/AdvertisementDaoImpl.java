package org.example.final_project.dao.impl;

import jakarta.persistence.*;
import org.example.final_project.dao.AdvertisementDao;
import org.example.final_project.domain.Advertisement;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
@Repository
@Transactional
public class AdvertisementDaoImpl implements AdvertisementDao {

    @PersistenceContext
   EntityManager em;

    @Override
    public void   update(Advertisement advertisement) throws SQLException {
        Advertisement advertisement1 = em.merge(advertisement);
        em.persist(advertisement1);


    }

    @Override
    public void add(Advertisement advertisement) {
        em.persist(advertisement);

    }


    @Override
    public Advertisement findById(int id) throws SQLException {
        return em.find(Advertisement.class, id);
    }

    @Override
    public void removeById(int id) throws SQLException {

        Query query = em.createQuery("DELETE FROM Advertisement c WHERE c.id =: c_id");
        query.setParameter("c_id", id);
        query.executeUpdate();

    }

    @Override
    public List<Advertisement> getByCategory(String name) throws SQLException {

        TypedQuery<Advertisement> query =
                em.createQuery("SELECT a FROM Advertisement a WHERE a.category.name = :category_name",
                        Advertisement.class);

        query.setParameter("category_name",name);
        List<Advertisement> advertisement = query.getResultList();
        return advertisement;
    }

    @Override
    public List<Advertisement> showByAuthor(String name) throws SQLException {
        TypedQuery<Advertisement> query =
                em.createQuery("SELECT a FROM Advertisement a WHERE a.author.name = :author_name ",
                        Advertisement.class);
        query.setParameter("author_name", name);
        List<Advertisement> advertisement = query.getResultList();
        return advertisement;
    }

    @Override
    public List<Advertisement> showByKeyWord(String keyWord) throws SQLException {
        TypedQuery<Advertisement> query =
                em.createQuery("SELECT a FROM Advertisement a WHERE a.advert_text LIKE " +
                                "CONCAT('%', :keyword, '%')",
                Advertisement.class);
        query.setParameter("keyword", keyWord);
        return query.getResultList();
    }

    @Override
    public List<Advertisement> showByDate(LocalDate date) throws SQLException {
        TypedQuery<Advertisement> query =
                em.createQuery("SELECT a FROM Advertisement a WHERE a.date = :a_date ",
        Advertisement.class);
        query.setParameter("a_date",date);
        return query.getResultList();
    }
}
