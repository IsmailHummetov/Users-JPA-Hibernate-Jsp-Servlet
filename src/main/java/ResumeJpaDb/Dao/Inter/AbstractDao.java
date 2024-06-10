package ResumeJpaDb.Dao.Inter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;


public class AbstractDao {

    public Connection connection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/resume";
        String username = "root";
        String password="12345";
        Connection c = DriverManager.getConnection(url,username,password);
        return c;
    }
    private EntityManagerFactory emf=null;
    public EntityManager em(){
        if(emf==null){
            emf= Persistence.createEntityManagerFactory("resumejpadbPU");
        }
        EntityManager entityManager = emf.createEntityManager();
        return entityManager;
    }
    public void closeEMF(){
        emf.close();
    }

}
