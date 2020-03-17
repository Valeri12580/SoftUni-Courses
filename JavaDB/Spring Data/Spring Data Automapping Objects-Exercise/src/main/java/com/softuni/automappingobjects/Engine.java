package com.softuni.automappingobjects;

import com.softuni.automappingobjects.entities.dtos.AddGameDto;
import com.softuni.automappingobjects.entities.dtos.LoginUserDto;
import com.softuni.automappingobjects.entities.dtos.RegisterUserDto;
import com.softuni.automappingobjects.services.implementation.GameServiceImpl;
import com.softuni.automappingobjects.services.implementation.UserServiceImpl;
import com.softuni.automappingobjects.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Component
public class Engine implements CommandLineRunner {
    private final BufferedReader reader;
    public final UserServiceImpl userService;
    public final GameServiceImpl gameService;
    private final ValidationUtil validationUtil;


    @Autowired
    public Engine(BufferedReader reader, UserServiceImpl userService, GameServiceImpl gameService, ValidationUtil validationUtil) {
        this.reader = reader;
        this.userService = userService;
        this.gameService = gameService;
        this.validationUtil = validationUtil;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("The program will stop when you write 'End'\n" +
                "Enter input:");
        String[] input = reader.readLine().split("\\|");
        while (!input[0].equals("End")) {




            String command = input[0];
            String email;
            String password;
            long id;
            switch (command) {
                case "RegisterUser":
                    email = input[1];
                    password = input[2];
                    String confirmPassword = input[3];
                    String fullName = input[4];

                    RegisterUserDto registerUserDto = new RegisterUserDto(email, password, fullName);
                    if (this.validationUtil.isValid(registerUserDto)) {
                        if (password.equals(confirmPassword)) {

                            this.userService.registerUser(registerUserDto);


                        } else {
                            System.out.println("Passwords doesn't match!");
                        }
                    } else {
                        this.validationUtil.getViolations(registerUserDto).forEach(e -> System.out.println(e.getMessage()));
                    }


                    break;

                case "LoginUser":
                    email = input[1];
                    password = input[2];
                    LoginUserDto loginUserDto = new LoginUserDto(email, password);
                    this.userService.loginUser(loginUserDto);


                    break;

                case "Logout":
                    this.userService.logout();
                    break;

                case "AddGame":
                    String title = input[1];
                    double price = Double.parseDouble(input[2]);
                    double size = Double.parseDouble(input[3]);
                    String trailer = input[4].substring(input[4].lastIndexOf("=") == -1 ? 0 : input[4].lastIndexOf("="));
                    String thumbnail = input[5];
                    String description = input[6];
                    LocalDate releaseDate = LocalDate.parse(input[7], DateTimeFormatter.ofPattern("dd-MM-yyyy"));


                    AddGameDto addGameDto = new AddGameDto(title, price, size, trailer, thumbnail, description, releaseDate);
                    if (validationUtil.isValid(addGameDto)) {
                        this.gameService.addGame(addGameDto);
                    } else {
                        validationUtil.getViolations(addGameDto).forEach(e -> System.out.println(e.getMessage()));
                    }
                    break;

                case "EditGame":
                    id = Long.parseLong(input[1]);
                    this.gameService.editGame(id, Arrays.copyOfRange(input, 2, input.length));
                    break;

                case "DeleteGame":
                    id = Long.parseLong(input[1]);
                    this.gameService.deleteGame(id);
                    break;

                case "AllGames":
                    this.gameService.showAllGames();
                    break;

                case "DetailGame":

                    String gameName = input[1];
                    this.gameService.showDetailsForGame(gameName);
                    break;

                case "OwnedGames":

                    break;
            }

            System.out.println("Input:");
            input = reader.readLine().split("\\|");
        }
    }

}
