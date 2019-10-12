import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        List<Integer>numbers= Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String input="";

        while (!"end".equals(input=reader.readLine())){
            String[] command=input.split("\\s+");
            switch (command[0]){
                case "Delete":
                    int element=Integer.parseInt(command[1]);
                    numbers=numbers.stream().filter(e ->!e.equals(element)).collect(Collectors.toList());

                    break;
                case "Insert":
                    if(Integer.parseInt(command[2])>=0 && Integer.parseInt(command[2])<numbers.size()){
                        numbers.add(Integer.parseInt(command[2]),Integer.parseInt(command[1]));
                    }


                    break;
            }




        }

        System.out.println(numbers.toString().replaceAll("[\\[,\\]]",""));

    }
}
