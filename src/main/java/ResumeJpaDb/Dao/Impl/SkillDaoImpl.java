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

public class SkillDaoImpl extends AbstractDao implements SkillDaoInter {

    @Override
    public List<Skill> getAll() {
        EntityManager em = em();
        List<Skill> skill;
        Query query = em.createQuery("SELECT s from Skill s");
        skill = query.getResultList();
        em.close();
        return skill;
    }

    @Override
    public Skill getById(int skillId) {
        EntityManager em = em();
        Skill skill = em.find(Skill.class,skillId);
        em.close();
        return skill;
    }

    @Override
    public boolean addSkill(Skill skill) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(skill);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean deleteSkill(int SkillId) {
        EntityManager em = em();
        Skill skill = em.find(Skill.class,SkillId);
        em.getTransaction().begin();
        em.remove(skill);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean update(Skill skill) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(skill);
        em.getTransaction().commit();
        em.close();
        return true;
    }
}
