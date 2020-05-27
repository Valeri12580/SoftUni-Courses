package bg.example.exampreparation.models.dtos;

import bg.example.exampreparation.models.entities.Gender;

public class UserRegisterDto {
    private String username;
    private String password;
    private Gender gender;

    public UserRegisterDto(String username, String password, Gender gender) {
        this.username = username;
        this.password = password;
        this.gender = gender;
    }

    public UserRegisterDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
