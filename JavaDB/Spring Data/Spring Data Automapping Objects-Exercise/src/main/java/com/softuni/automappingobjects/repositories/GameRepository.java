package com.softuni.automappingobjects.repositories;

import com.softuni.automappingobjects.entities.Game;
import com.softuni.automappingobjects.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {
    Game findGameByTitle(String title);

    List<Game> findAllByUser(User user);

}
