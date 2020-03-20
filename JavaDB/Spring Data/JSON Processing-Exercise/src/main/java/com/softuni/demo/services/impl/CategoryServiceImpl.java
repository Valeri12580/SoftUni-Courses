package com.softuni.demo.services.impl;

import com.google.gson.Gson;
import com.softuni.demo.dtos.ThirdExerciseDto;
import com.softuni.demo.entities.Category;
import com.softuni.demo.entities.Product;
import com.softuni.demo.repositories.CategoryRepository;
import com.softuni.demo.services.CategoryService;
import com.softuni.demo.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMap;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMap) {
        this.categoryRepository = categoryRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMap = modelMap;
    }

    @Override
    public void seedCategories() throws FileNotFoundException {
        Category[]categories=this.gson.fromJson(new FileReader("src/main/resources/files/categories.json"),Category[].class);
        for (Category category : categories) {
            if(validationUtil.isValid(category)){
                this.categoryRepository.save(category);
            }else{
                validationUtil.getViolations(category)
                .forEach(e-> System.out.println(e.getMessage()));
            }

        }
    }

    @Override
    public Set<Category> generateRandomCategories() {
        Random random=new Random();
        Set<Category>categories = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            int randomInt = random.nextInt((int)this.categoryRepository.count())+1;
            Category randomCat=this.categoryRepository.findById((long)randomInt).get();
            categories.add(randomCat);
        }
        return categories;
    }

    @Override
    public String thirdExercise() {
        List<ThirdExerciseDto>result=this.categoryRepository.thirdExercise().stream()
                .map(c->{
                    double avg=c.getProducts().stream()
                            .map(Product::getPrice).mapToDouble(Double::doubleValue).sum()/c.getProducts().size();
                    double totalRevenue=c.getProducts().stream().map(Product::getPrice).mapToDouble(Double::doubleValue).sum();

                    ThirdExerciseDto dto=this.modelMap.map(c,ThirdExerciseDto.class);
                    System.out.println();
                    dto.setAveragePrice(avg);
                    dto.setTotalRevenue(totalRevenue);
                    dto.setProductsCount(c.getProducts().size());
                    return dto;

                }).collect(Collectors.toList());
        return this.gson.toJson(result);
    }
}
