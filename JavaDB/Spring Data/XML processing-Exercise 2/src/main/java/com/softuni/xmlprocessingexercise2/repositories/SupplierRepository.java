package com.softuni.xmlprocessingexercise2.repositories;

import com.softuni.xmlprocessingexercise2.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {

    @Query("SELECT s.id,s.name,s.parts.size FROM Supplier as s where s.isImporter=false")
    List<Object[]>thirdExercise();


}
