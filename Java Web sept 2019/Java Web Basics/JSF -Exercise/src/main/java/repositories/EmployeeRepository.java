package repositories;

import models.entities.Employee;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class EmployeeRepository {
    private EntityManager entityManager;

    @Inject
    public EmployeeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Employee employee) {
        this.entityManager.getTransaction().begin();

        this.entityManager.persist(employee);

        this.entityManager.getTransaction().commit();
    }

    public List<Employee> getAllEmployees() {

        return this.entityManager.createQuery("SELECT e FROM Employee e ", Employee.class).getResultList();
    }

    public void removeEmployeeById(int id) {
        this.entityManager.getTransaction().begin();

        this.entityManager.createQuery("DELETE FROM Employee WHERE id=:id").setParameter("id", id).executeUpdate();

        this.entityManager.getTransaction().commit();

    }

    public Double getSalarySum() {
        Double singleResult = this.entityManager.createQuery("SELECT sum(e.salary) FROM Employee  e ", BigDecimal.class).getSingleResult().doubleValue();
        return singleResult;


    }

    public Double getAverageSalary() {
        Double singleResult = (Double) this.entityManager.createQuery("SELECT avg(e.salary) FROM Employee  e ").getSingleResult();
        return singleResult;
    }

}
