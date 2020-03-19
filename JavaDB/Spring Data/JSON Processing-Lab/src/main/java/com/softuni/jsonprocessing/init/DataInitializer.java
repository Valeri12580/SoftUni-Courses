package com.softuni.jsonprocessing.init;

import com.softuni.jsonprocessing.model.Post;
import com.softuni.jsonprocessing.model.User;
import com.softuni.jsonprocessing.service.PostService;
import com.softuni.jsonprocessing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private  PostService postService;

    @Autowired
    private UserService userService;

    private static final List<Post> SAMPLE_POSTS=List.of(
                new Post("Welcome to Spring","Developing data access objects with spring data"),
                new Post(" Reactive Spring","Trying reactive spring"),
                new Post("Test","Testing our application"));
    private static final List<User> SAMPLE_USERS=List.of(
            new User("Valeri","Stoqnov","valeri125602","1234"),
            new User("Kacho","Enchev","Kachimilka","1234")
            );



    @Override
    public void run(String... args) throws Exception {
        SAMPLE_USERS.forEach(e-> {
            userService.addUser(e);

        });


        SAMPLE_POSTS.forEach(e->{{
            e.setAuthor(this.userService.getUserById(1l));
            postService.addPost(e);

        }});
    }
}
