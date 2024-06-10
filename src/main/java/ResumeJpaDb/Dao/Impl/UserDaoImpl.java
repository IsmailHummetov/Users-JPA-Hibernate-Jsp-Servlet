package ResumeJpaDb.Dao.Impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import ResumeJpaDb.Dao.Inter.*;
import ResumeJpaDb.Entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class UserDaoImpl extends AbstractDao implements UserDaoInter {

    @Override
    public List<User> getAll() {
        EntityManager em = em();
        Query query = em.createQuery("SELECT u from User u");
        List<User> userList = query.getResultList();
        em.close();
        return userList;
    }

    public List<User> getByNameSurname(String firstname, String lastname) {
        EntityManager em = em();
        String jpql = "SELECT u from User u where 1=1";

        if (firstname != null && !firstname.trim().isEmpty())
            jpql += " and u.firstname=:firstname";
        if (lastname != null && !lastname.trim().isEmpty())
            jpql += " and u.lastname=:lastname";

        Query query = em.createQuery(jpql, User.class);

        if (firstname != null && !firstname.trim().isEmpty())
            query.setParameter("firstname", firstname);
        if (lastname != null && !lastname.trim().isEmpty())
            query.setParameter("lastname", lastname);
        List<User> userList = query.getResultList();
        em.close();
        return userList;
    }

    @Override
    public User getbyId(int UserId) {
        EntityManager em = em();
        User u = em.find(User.class, UserId);
        em.close();
        return u;
    }

    //    @Override
//    public User getByEmail(String email) {
//        EntityManager em = em();
//        Query query  = em.createQuery("SELECT u from User u where u.email=:email");
//        query.setParameter("email",email);
//        List<User> user =query.getResultList();
//        em.close();
//        if (user.size()==1)
//            return user.get(0);
//        return null;
//    }
    @Override
    public User getByEmail(String email) {
        EntityManager em = em();
        Query query = em.createNamedQuery("User.findByEmail");
        query.setParameter("email", email);
        List<User> user = query.getResultList();
        em.close();
        if (user.size() == 1)
            return user.get(0);
        return null;
    }

    @Override
    public List<UserSkill> getAllSkillById(int userId) {
        EntityManager em = em();
        Query query = em.createQuery("SELECT us from UserSkill us WHERE us.user.id=:userId");
        query.setParameter("userId", userId);
        List<UserSkill> userSkills = null;
        userSkills = query.getResultList();
        em.close();
        return userSkills;
    }

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryById(int userId) {
        EntityManager em =em();
        Query query = em.createQuery("SELECT eh from EmploymentHistory eh WHERE eh.user.id=:userId");
        query.setParameter("userId",userId);
        List<EmploymentHistory> employmentHistories = query.getResultList();
        em.close();
        return employmentHistories;
    }


    @Override
    public boolean addUser(User user) {
        EntityManager em = em();
        BCrypt.Hasher crypt = BCrypt.withDefaults();
        user.setPassword(crypt.hashToString(4, user.getPassword().toCharArray()));
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean deleteUser(int UserId) {
        EntityManager em = em();
        User user = em.find(User.class, UserId);
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
        em.close();
        return true;
    }
}
