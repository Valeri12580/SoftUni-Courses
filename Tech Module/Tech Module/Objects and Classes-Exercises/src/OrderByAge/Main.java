package OrderByAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String input="";
        List<OrderByAge> storage=new ArrayList<>();
        while (!"End".equals(input=reader.readLine())){
            String data[]=input.split(" ");

            OrderByAge person=new OrderByAge(data[0],data[1],Integer.parseInt(data[2]));

            storage.add(person);
        }

        storage=storage.stream().sorted((p1,p2)->Integer.compare(p1.getAge(),p2.getAge())).collect(Collectors.toList());


        for (OrderByAge print:storage
             ) {
            System.out.printf("%s with ID: %s is %d years old.%n",print.getName(),print.getId(),print.getAge());
        }


    }


}
