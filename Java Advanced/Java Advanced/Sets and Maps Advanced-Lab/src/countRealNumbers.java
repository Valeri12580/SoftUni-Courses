import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class countRealNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        double[]input= Arrays.stream(reader.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        Map<Double,Integer>numbers=new LinkedHashMap<>();

        for (int i = 0; i <input.length ; i++) {

            double currentNum=input[i];

            if(!numbers.containsKey(currentNum)){
                numbers.put(currentNum,1);
            }else{
                numbers.put(currentNum,numbers.get(currentNum)+1);
            }

        }

        numbers.entrySet().stream().forEach(e->{
            System.out.println(String.format("%.1f -> %d",e.getKey(),e.getValue()));
        });
    }



}
