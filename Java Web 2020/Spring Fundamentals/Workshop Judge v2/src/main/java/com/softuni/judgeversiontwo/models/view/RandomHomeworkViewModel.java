package com.softuni.judgeversiontwo.models.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RandomHomeworkViewModel {
    private long homeworkId;
    private Integer score;
    private String content;
    private String git;
    private long currentUserCheckingId;


}
