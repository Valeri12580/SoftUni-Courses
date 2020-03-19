package com.softuni.jsonprocessing.service.impl;

import com.softuni.jsonprocessing.dao.PostRepository;
import com.softuni.jsonprocessing.dao.UserRepository;
import com.softuni.jsonprocessing.exceptions.InvalidEntityException;
import com.softuni.jsonprocessing.model.Post;
import com.softuni.jsonprocessing.model.User;
import com.softuni.jsonprocessing.service.PostService;
import com.softuni.jsonprocessing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Date;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public Collection<Post> getPosts() {
        return this.postRepository.findAll();
    }

    @Override
    public Post addPost(Post post) {
        Long authorId;
        if(post.getAuthor()!=null){
            authorId=post.getAuthor().getId();
        }else{
            authorId=post.getAuthorId();
        }

        if(authorId!=null){
            User author=this.userRepository.findById(authorId).orElseThrow(()->new InvalidEntityException("Author with this ID doesnt  exist"));
            post.getAuthor();
        }

        if(post.getCreated() ==null){
            post.setCreated(new Date());
        }
        post.setModified(post.getCreated());


//        return this.postRepository.;

        return  this.postRepository.save(post);
    }

    @Override
    public Post updatePost(Post post) {
        return null;
    }

    @Override
    public Post deletePost(long id) {
        return null;
    }

    @Override
    public long getPostCount() {
        return 0;
    }
}
