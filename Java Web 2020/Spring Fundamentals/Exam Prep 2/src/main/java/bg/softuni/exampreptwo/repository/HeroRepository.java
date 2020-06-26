package bg.softuni.exampreptwo.repository;

import bg.softuni.exampreptwo.models.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository  extends JpaRepository<Hero,String> {


}
