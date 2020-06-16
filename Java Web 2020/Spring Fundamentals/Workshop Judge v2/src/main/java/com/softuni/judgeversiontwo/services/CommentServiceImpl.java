package com.softuni.judgeversiontwo.services;

import com.softuni.judgeversiontwo.models.entities.Comment;
import com.softuni.judgeversiontwo.models.view.RandomHomeworkViewModel;
import com.softuni.judgeversiontwo.repositories.CommentRepository;
import com.softuni.judgeversiontwo.services.interfaces.CommentService;
import com.softuni.judgeversiontwo.services.interfaces.HomeworkService;
import com.softuni.judgeversiontwo.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private ModelMapper modelMapper;
    private UserService userService;
    private HomeworkService homeworkService;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, ModelMapper modelMapper, UserService userService, HomeworkService homeworkService) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.homeworkService = homeworkService;
    }

    @Override
    public void checkHomework(RandomHomeworkViewModel randomHomeworkViewModel) {
        Comment comment=this.modelMapper.map(randomHomeworkViewModel,Comment.class);
        comment.setAuthor(this.userService.getUserById(randomHomeworkViewModel.getCurrentUserCheckingId()));
        comment.setHomework(this.homeworkService.getHomeworkById(randomHomeworkViewModel.getHomeworkId()));

        this.commentRepository.save(comment);

    }
}
