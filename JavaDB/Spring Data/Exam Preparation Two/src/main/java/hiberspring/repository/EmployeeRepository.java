package hiberspring.repository;

import hiberspring.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//TODO
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e where e.branch.products.size>=1 ORDER BY CONCAT(e.firstName,' ',e.lastName) ASC ,e.card.number,LENGTH(e.position)DESC ")
    List<Employee> exportData();
}
