package foodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int n =Integer.parseInt(reader.readLine());
        Map<String,Buyer> data=new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[]input=reader.readLine().split(" ");

            if(input.length==4){
                data.put(input[0],new Citizen(input[0],Integer.parseInt(input[1]),input[2],input[3]));

            }else{
                data.put(input[0],new Rebel(input[0],Integer.parseInt(input[1]),input[2]));
            }
        }

        String command="";
        int food=0;
        while (!"End".equals(command=reader.readLine())){
            if(data.containsKey(command)){
               data.get(command).buyFood();
            }
        }
        int sum=0;
        for (Map.Entry<String, Buyer> stringPersonEntry : data.entrySet()) {
            sum+=stringPersonEntry.getValue().getFood();

        }
        System.out.println(sum);


    }
}
