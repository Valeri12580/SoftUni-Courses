import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Orders {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String[]input=reader.readLine().split("\\s+");
        Map<String, List<Double>>result=new LinkedHashMap<>();
        while (!input[0].equals("buy")){
            String name=input[0];
            double price=Double.parseDouble(input[1]);
            double q=Double.parseDouble(input[2]);
            List<Double>tata=new ArrayList<>();
            result.putIfAbsent(name,tata);
            if(result.get(name).isEmpty()){
                result.get(name).add(price);
                result.get(name).add(q);
            }else{
                if(result.get(name).get(0)!=price){
                    result.get(name).set(0,price);
                }

                result.get(name).set(1,result.get(name).get(1)+q);
            }


            input=reader.readLine().split("\\s+");
        }

        result.entrySet().forEach(e-> System.out.println(String.format("%s -> %.2f",e.getKey(),e.getValue().get(0)*e.getValue().get(1))));
    }
}
