package ResumeJpaDb.Dao.Inter;


import ResumeJpaDb.Entity.UserSkill;

import java.util.List;

public interface UserSkillDaoInter {
    List<UserSkill> getAllUserSkill();
    UserSkill getById(int id);

    boolean addUserSkill(UserSkill us);

    boolean updateUserSkill(UserSkill us);

    boolean deleteUserSkill(int id);
}
