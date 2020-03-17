package com.softuni.automappingobjects.services.implementation;

import com.softuni.automappingobjects.entities.Game;
import com.softuni.automappingobjects.entities.dtos.AddGameDto;
import com.softuni.automappingobjects.entities.dtos.DetailsGameDto;
import com.softuni.automappingobjects.entities.dtos.ShowGamesDto;
import com.softuni.automappingobjects.repositories.GameRepository;
import com.softuni.automappingobjects.services.interfaces.GameService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final UserServiceImpl userService;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, UserServiceImpl userService) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }


    @Override
    public void addGame(AddGameDto addGameDto) {
        if(isAdmin()){
            Game game = modelMapper.map(addGameDto, Game.class);
            this.gameRepository.save(game);
            System.out.println("Added " + game.getTitle());
        }else{
            System.out.println("Only admins can add games!");
        }

    }

    @Override
    public void editGame(long id, String[] parts) throws NoSuchFieldException, IllegalAccessException {
        if(isAdmin()){
            Game game = this.gameRepository.findById(id).get();
            for (String part : parts) {
                String[] secondSplit = part.split("=");
                String property = secondSplit[0];
                if (isNumeric(secondSplit[1])) {
                    double number = Double.parseDouble(secondSplit[1]);
                    setObjectField(game, property, number);

                } else {
                    String value = secondSplit[1];
                    setObjectField(game, property, value);
                }
            }
            this.gameRepository.save(game);
            System.out.println(String.format("%s is edited. ", game.getTitle()));
        }else{
            System.out.println("Only admins can edit games!");
        }


    }

    @Override
    public void deleteGame(long id) {
        if(isAdmin()){
            this.gameRepository.deleteById(id);
            System.out.println("Deleted");
        }else{
            System.out.println("Only admins can delete games!");
        }

    }

    @Override
    public void showAllGames() {
        ShowGamesDto[] showGamesDtos = this.gameRepository.findAll()
                .stream()
                .map(e -> new ShowGamesDto(e.getTitle(), e.getPrice()))
                .toArray(ShowGamesDto[]::new);
        Arrays.stream(showGamesDtos).forEach(e-> System.out.printf("%s %.2f%n",e.getTitle(),e.getPrice()));

    }

    @Override
    public void showDetailsForGame(String gameTitle) {
        Game game=this.gameRepository.findGameByTitle(gameTitle);
        DetailsGameDto details=this.modelMapper.map(game,DetailsGameDto.class);

        System.out.printf("Title: %s\nPrice: %.2f\nDescription: %s\nRelease date: %s"
        , game.getTitle(), game.getPrice(), game.getDescription(),game.getDate());

    }

    @Override
    public void ownedGames() {
        //bi trqbvalo da se izpolzva dto s name,no prosto nqma smisul da si gubim vremeto...
//        List<Game> userGames=this.gameRepository.findAllByUser(this.userService.user);
//        userGames.forEach(e-> System.out.println(e.getTitle()));

        //ne raboti zashtoto iska  5-ta zadacha koqto ne e zaduljitelna


    }

    private void setObjectField(Game game, String property, double number) throws NoSuchFieldException, IllegalAccessException {
        Field field = Game.class.getDeclaredField(property);
        field.setAccessible(true);
        field.set(game, number);
    }

    private void setObjectField(Game game, String property, String value) throws NoSuchFieldException, IllegalAccessException {
        Field field = Game.class.getDeclaredField(property);
        field.setAccessible(true);
        field.set(game, value);
    }


    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public   boolean isAdmin(){
        return this.userService.user.getRole().toString().equals("Administrator");
    }
}
