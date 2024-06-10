package ResumeJpaDb.Main;

import ResumeJpaDb.Dao.Inter.*;
import ResumeJpaDb.Entity.*;
import ResumeJpaDb.Main.Context;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        EmpHistoryDaoInter empHistoryDaoInter = Context.instanceEmpHistoryDao();
        for (EmploymentHistory employmentHistory : empHistoryDaoInter.getAllEmploymentHistory())
            System.out.println(employmentHistory.getHeader()+" "+employmentHistory.getUser().getFirstname());
    }
}
