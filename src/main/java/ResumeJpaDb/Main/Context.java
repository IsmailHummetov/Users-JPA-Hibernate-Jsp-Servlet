package ResumeJpaDb.Main;

import ResumeJpaDb.Dao.Inter.*;
import ResumeJpaDb.Dao.Impl.*;
import ResumeJpaDb.Entity.*;
import ResumeJpaDb.Main.Context;

public class Context {
    public static UserDaoInter instanceUserDao() {
        return new UserDaoImpl();
    }

    public static UserSkillDaoInter instanceUserSkillDao() {
        return new UserSkillDaoImpl();
    }

    public static EmpHistoryDaoInter instanceEmpHistoryDao() {
        return new EmpHistoryDaoImpl();
    }

    public static SkillDaoInter instanceSkillDao() {
        return new SkillDaoImpl();
    }

    public static CountryDaoInter instanceCountryDao() {
        return new CountryDaoImpl();
    }
}