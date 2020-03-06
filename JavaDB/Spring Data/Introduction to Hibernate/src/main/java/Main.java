import entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

//        Configuration cfg=new Configuration().configure();
//
//        SessionFactory sessionFactory=cfg.buildSessionFactory();
//        Session currentSession=sessionFactory.openSession();
//        currentSession.beginTransaction();
//        Employee firstEmployee=new Employee("Valeri","Stoqnov");
//
//        currentSession.save(firstEmployee);
//        currentSession.getTransaction().commit();
//        currentSession.close();

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("hibernate_test");

        EntityManager manager=emf.createEntityManager();
        manager.getTransaction().begin();
        Employee emp=manager.find(Employee.class,1);

        
        manager.getTransaction().commit();
        System.out.println(emp.getFirstName());


    }
}
