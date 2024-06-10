package ResumeJpaDb.Dao.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import ResumeJpaDb.Dao.Inter.*;
import ResumeJpaDb.Entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl extends AbstractDao implements CountryDaoInter {


    @Override
    public List<Country> getAll() {
        EntityManager em = em();
        Query query = em.createQuery("SELECT c from Country c");
        List<Country> countries = query.getResultList();
        em.close();
        return countries;
    }

    @Override
    public Country getById(int CountryId) {
        EntityManager em = em();
        Country country = em.find(Country.class,CountryId);
        em.close();
        return country;
    }

    @Override
    public boolean addCountry(Country country) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean updateCountry(Country country) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(country);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean deleteCountry(int CountryId) {
        EntityManager em = em();
        Country country = em.find(Country.class,CountryId);
        em.getTransaction().begin();
        em.remove(country);
        em.getTransaction().commit();
        em.close();
        return true;
    }
}
