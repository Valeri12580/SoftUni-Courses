package com.softuni.webflux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class FluxMonoExplained {

    private User user = new User("Valeri", "Stoqnov");
    private User user2 = new User("Stiliana", "K");

    public Flux<User> getAllUsersFlux() {
        return Flux.just(user, user2);
    }

    public Mono<User> getUserMono() {
        if (isAuth()) {
            return Mono.just(user);
        }
        return Mono.empty();

    }

    public List<User> getAllUsers() {
        return List.of(user, user2);

    }

    public User getUser() {
        if (isAuth()) {
            return user;
        }
        return null;
    }

    public Optional<User> getUserOpt() {
        if (isAuth()) {
            return Optional.of(user);
        }
        return Optional.empty();
    }

    private boolean isAuth() {
        return new Random().nextBoolean();
    }
}

class User {
    private String firstName, lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}