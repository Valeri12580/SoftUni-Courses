package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import softuni.exam.domain.Player;

import java.math.BigDecimal;
import java.util.List;

public interface PlayerRepository  extends JpaRepository<Player,Integer> {

    List<Player>findAllBySalaryGreaterThan(BigDecimal salary);

    @Query("SELECT p FROM Player as p WHERE p.team.name=:name")
    List<Player>findAllByTeamName(@Param("name") String name);

}
