package com.softuni.demo.services.impl;

import com.google.gson.Gson;
import com.softuni.demo.dtos.firstExerciseDto;
import com.softuni.demo.entities.Product;
import com.softuni.demo.repositories.ProductRepository;
import com.softuni.demo.services.CategoryService;
import com.softuni.demo.services.ProductService;
import com.softuni.demo.services.UserService;
import com.softuni.demo.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final UserService userService;
    private final CategoryService categoryService;

    private final ModelMapper modelMap;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, Gson gson, ValidationUtil validationUtil, UserService userService, CategoryService categoryService, ModelMapper modelMap) {
        this.productRepository = productRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.userService = userService;
        this.categoryService = categoryService;

        this.modelMap = modelMap;
    }

    @Override
    public void seedProducts() throws FileNotFoundException {
        Product[] products = this.gson.fromJson(new FileReader("src/main/resources/files/products.json"), Product[].class);
        for (Product product : products) {
            if (validationUtil.isValid(product)) {
                product.setBuyer(this.userService.getRandomBuyer());
                product.setSeller(this.userService.getRandomSeller());
                product.setCategories(this.categoryService.generateRandomCategories());
                this.productRepository.save(product);
            } else {
                validationUtil.getViolations(product)
                        .forEach(e -> System.out.println(e.getMessage()));
            }

        }

    }

    @Override
    public String firstExercise(double low, double high) {
        List<firstExerciseDto> result = this.productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPriceAsc(low, high)
                .stream().map(e -> {
                    firstExerciseDto firstExerciseDto = this.modelMap.map(e, firstExerciseDto.class);

                    firstExerciseDto.setSeller(String.format("%s %s", e.getSeller().getFirstName(), e.getSeller().getLastName()));
                    return firstExerciseDto;
                }).collect(Collectors.toList());

        return gson.toJson(result);


    }
}
