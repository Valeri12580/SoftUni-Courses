package hiberspring.repository;

import hiberspring.domain.entities.EmployeeCard;
import org.springframework.data.jpa.repository.JpaRepository;

//TODO
public interface EmployeeCardRepository extends JpaRepository<EmployeeCard,Integer> {

    EmployeeCard findByNumber(String number);

}
