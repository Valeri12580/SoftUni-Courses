package com.softuni.jsonprocessing.service;

import com.softuni.jsonprocessing.model.Post;

import java.util.Collection;

public interface PostService {
    Collection<Post>getPosts();

    Post addPost(Post post);

    Post updatePost(Post post);

    Post deletePost(long id);

    long getPostCount();


}
