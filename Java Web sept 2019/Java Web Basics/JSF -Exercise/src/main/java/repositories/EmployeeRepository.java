package repositories;

import models.entities.Employee;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class EmployeeRepository {
    private EntityManager entityManager;

    @Inject
    public EmployeeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public  void save(Employee employee){
        this.entityManager.getTransaction().begin();

        this.entityManager.persist(employee);


        this.entityManager.getTransaction().commit();
    }

    public List<Employee>getAllEmployees(){

        return this.entityManager.createQuery("SELECT e FROM Employee e ",Employee.class).getResultList();
    }

}
