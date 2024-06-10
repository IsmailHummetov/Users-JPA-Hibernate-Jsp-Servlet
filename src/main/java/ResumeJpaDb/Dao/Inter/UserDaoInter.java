package ResumeJpaDb.Dao.Inter;


import ResumeJpaDb.Entity.EmploymentHistory;
import ResumeJpaDb.Entity.User;
import ResumeJpaDb.Entity.UserSkill;

import java.util.List;

public interface UserDaoInter {

    List<User> getAll();

    List<User> getByNameSurname(String firstname, String lastname);

    User getbyId(int UserId);

    User getByEmail(String email);

    List<UserSkill> getAllSkillById(int userId);
    List<EmploymentHistory> getAllEmploymentHistoryById(int userId);

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int UserId);
}
