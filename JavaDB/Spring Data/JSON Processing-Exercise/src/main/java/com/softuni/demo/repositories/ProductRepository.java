package com.softuni.demo.repositories;

import com.softuni.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Set<Product>findAllByPriceBetweenAndBuyerIsNullOrderByPriceAsc(double low,double high);
}
