package ResumeJpaDb.Dao.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import ResumeJpaDb.Dao.Inter.*;
import ResumeJpaDb.Entity.*;
import ResumeJpaDb.Main.Context;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserSkillDaoImpl extends AbstractDao implements UserSkillDaoInter {

    @Override
    public List<UserSkill> getAllUserSkill() {
        EntityManager em = em();
        Query query = em.createQuery("SELECT us from UserSkill us");
        List<UserSkill> userSkills = query.getResultList();
        em.close();
        return userSkills;
    }

    @Override
    public UserSkill getById(int id) {
        EntityManager em = em();
        UserSkill userSkill = em.find(UserSkill.class, id);
        em.close();
        return userSkill;
    }

    @Override
    public boolean addUserSkill(UserSkill us) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(us);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean updateUserSkill(UserSkill us) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(us);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean deleteUserSkill(int id) {
        EntityManager em = em();
        UserSkill userSkill = em.find(UserSkill.class, id);
        em.getTransaction().begin();
        em.remove(userSkill);
        em.getTransaction().commit();
        em.close();
        return true;
    }
}
