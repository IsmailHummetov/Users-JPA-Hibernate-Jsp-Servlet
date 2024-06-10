package ResumeJpaDb.Dao.Inter;


import ResumeJpaDb.Entity.EmploymentHistory;

import java.util.List;

public interface EmpHistoryDaoInter {
    List<EmploymentHistory> getAllEmploymentHistory();

    EmploymentHistory getById(int id);

    boolean addEmpHistory(EmploymentHistory emp);

    boolean updateEmpHistory(EmploymentHistory emp);

    boolean deleteEmpHistory(int id);
}
