package com.softuni.judgeversiontwo.repositories;

import com.softuni.judgeversiontwo.models.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends JpaRepository<Role,Long> {

    Role findByName(String name);
}
