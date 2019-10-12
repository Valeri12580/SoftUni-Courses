package reflection;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class refClass=Reflection.class;
        System.out.println("class "+refClass.getSimpleName());
        System.out.println(refClass.getSuperclass());
        for (Class anInterface : refClass.getInterfaces()) {
            System.out.println(anInterface);
        }


        Reflection newClass= (Reflection) refClass.getDeclaredConstructor().newInstance();
        System.out.println(newClass);


    }
}
