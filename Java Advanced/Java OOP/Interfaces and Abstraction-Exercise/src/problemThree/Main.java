package problemThree;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String[]input=reader.readLine().split(" ");

        List<Citizen>persons=new ArrayList<>();

        List<Pet>animals=new ArrayList<>();
        List<Robot>robots=new ArrayList<>();

        while (input.length!=1){
            if(input[0].equals("Citizen")){
                persons.add(new Citizen(input[1],Integer.parseInt(input[2]),input[3],input[4]));

            }else if (input[0].equals("Pet")) {

                animals.add(new Pet(input[1],input[2]));
            }else{
                robots.add(new Robot(input[1],input[2]));
            }

            input=reader.readLine().split(" ");

        }

        String year=reader.readLine();





        persons= persons.stream().filter(e->e.getBirthDate().contains(year)).collect(Collectors.toList());
        animals=animals.stream().filter(e->e.getBirthDate().contains(year)).collect(Collectors.toList());


        if(persons.isEmpty() && animals.isEmpty()){
            System.out.println("<no output>");
        }else{
            persons.forEach(e->{
                System.out.println(e.getBirthDate());
            });
            animals.forEach(e->{
                System.out.println(e.getBirthDate());
            });
        }



    }
}
