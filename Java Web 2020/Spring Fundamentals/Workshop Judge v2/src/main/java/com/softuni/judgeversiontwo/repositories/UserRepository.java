package com.softuni.judgeversiontwo.repositories;

import com.softuni.judgeversiontwo.models.entities.User;
import com.softuni.judgeversiontwo.models.service.UserServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


}
