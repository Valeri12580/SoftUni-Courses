package ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));


        List<String>list= Arrays.stream(reader.readLine().split("\\s+")).skip(1).collect(Collectors.toList());

        ListyIterator iterator=new ListyIterator(list);


        String input=reader.readLine();

        while (!"END".equals(input)){
            switch (input){
                case "Move":
                    System.out.println(iterator.move());
                    break;
                case  "HasNext":
                    System.out.println(iterator.hasNext());
                    break;


                case "Print":
                    try {
                        iterator.Print();
                    }catch (IllegalAccessException exception){
                        System.out.println(exception.getMessage());
                    }


                    break;
            }

            input=reader.readLine();
        }
    }
}
