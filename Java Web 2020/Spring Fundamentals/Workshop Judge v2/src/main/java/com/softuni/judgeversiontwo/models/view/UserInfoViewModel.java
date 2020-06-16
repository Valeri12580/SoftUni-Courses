package com.softuni.judgeversiontwo.models.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserInfoViewModel {
    private String username;
    private List<String> homeworksName;
    private String email;
    private String git;
}
