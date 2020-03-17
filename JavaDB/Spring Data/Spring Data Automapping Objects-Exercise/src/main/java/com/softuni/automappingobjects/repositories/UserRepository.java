package com.softuni.automappingobjects.repositories;

import com.softuni.automappingobjects.entities.User;
import com.softuni.automappingobjects.entities.dtos.LoginUserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmailAndPassword(String email,String password);

}
