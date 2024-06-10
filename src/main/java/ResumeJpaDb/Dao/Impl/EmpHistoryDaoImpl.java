package ResumeJpaDb.Dao.Impl;

import ResumeJpaDb.Dao.Inter.EmpHistoryDaoInter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import ResumeJpaDb.Dao.Inter.*;
import ResumeJpaDb.Entity.*;
import ResumeJpaDb.Main.Context;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpHistoryDaoImpl extends ResumeJpaDb.Dao.Inter.AbstractDao implements EmpHistoryDaoInter {

    @Override
    public List<ResumeJpaDb.Entity.EmploymentHistory> getAllEmploymentHistory() {
        EntityManager em = em();
        Query query = em.createQuery("SELECT eh from EmploymentHistory eh");
        List<ResumeJpaDb.Entity.EmploymentHistory> employmentHistories = query.getResultList();
        em.close();
        return employmentHistories;
    }

    @Override
    public ResumeJpaDb.Entity.EmploymentHistory getById(int id) {
        EntityManager em = em();
        ResumeJpaDb.Entity.EmploymentHistory employmentHistory = em.find(ResumeJpaDb.Entity.EmploymentHistory.class,id);
        em.close();
        return employmentHistory;
    }

    @Override
    public boolean addEmpHistory(ResumeJpaDb.Entity.EmploymentHistory emp) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean updateEmpHistory(ResumeJpaDb.Entity.EmploymentHistory emp) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(emp);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean deleteEmpHistory(int id) {
        EntityManager em = em();
        ResumeJpaDb.Entity.EmploymentHistory employmentHistory = em.find(ResumeJpaDb.Entity.EmploymentHistory.class,id);
        em.getTransaction().begin();
        em.remove(employmentHistory);
        em.getTransaction().commit();
        em.close();
        return true;
    }
}
