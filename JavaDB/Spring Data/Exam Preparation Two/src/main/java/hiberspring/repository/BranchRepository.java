package hiberspring.repository;


import hiberspring.domain.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

//TODO
public interface BranchRepository  extends JpaRepository<Branch,Long> {

    Branch findBranchByName(String name);
}
