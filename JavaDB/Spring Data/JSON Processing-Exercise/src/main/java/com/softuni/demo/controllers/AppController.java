package com.softuni.demo.controllers;

import com.softuni.demo.services.CategoryService;
import com.softuni.demo.services.ProductService;
import com.softuni.demo.services.UserService;
import com.softuni.demo.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppController implements CommandLineRunner {
   private final UserService userService;
   private final CategoryService categoryService;
   private final ProductService productService;
    private final FileUtil fileUtil;



   @Autowired
    public AppController(UserService userService, CategoryService categoryService, ProductService productService, FileUtil fileUtil) {
        this.userService = userService;
       this.categoryService = categoryService;
       this.productService = productService;
       this.fileUtil = fileUtil;
   }

    @Override
    public void run(String... args) throws Exception {

       //seed the data
//        this.userService.seedUsers();
//        this.categoryService.seedCategories();
//        this.productService.seedProducts();


        //Всеки път когато пробваш задача,изтрии съдържанието на result.txt
        //firstExercise
//        fileUtil.write(productService.firstExercise(500,1000));

        //secondExercise
//        fileUtil.write(this.userService.secondExercise());

        //thirdExercise
//        fileUtil.write(this.categoryService.thirdExercise());

      


    }




}
