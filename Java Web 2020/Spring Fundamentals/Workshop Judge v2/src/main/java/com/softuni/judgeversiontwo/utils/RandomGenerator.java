package com.softuni.judgeversiontwo.utils;

import java.util.Random;

public class RandomGenerator {
    public static Random random = new Random();

    public static long generateRandom(int bound){
        return random.nextInt(bound)+1;
    }
}
