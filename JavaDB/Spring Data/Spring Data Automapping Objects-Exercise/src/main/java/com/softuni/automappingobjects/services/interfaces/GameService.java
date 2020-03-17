package com.softuni.automappingobjects.services.interfaces;

import com.softuni.automappingobjects.entities.dtos.AddGameDto;

import java.time.LocalDate;

public interface GameService {

    void addGame(AddGameDto addGameDto);

    void editGame(long id,String[] parts) throws NoSuchFieldException, IllegalAccessException;

    void deleteGame(long id);

    void showAllGames();

    void showDetailsForGame(String gameName);

    void ownedGames();
}
