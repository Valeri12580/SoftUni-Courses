import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));


        Map<String, Map<String,Double>>magazines=new TreeMap<>();

        String input;

        while (!"Revision".equals(input=reader.readLine())){
            String[]information=input.split(", ");
            String magazine=information[0];
            String product=information[1];
            Double price=Double.parseDouble(information[2]);

            magazines.putIfAbsent(magazine,new LinkedHashMap<>());
            magazines.get(magazine).putIfAbsent(product,price);


        }

        for (Map.Entry<String, Map<String, Double>> firstEntry : magazines.entrySet()) {
            System.out.println(firstEntry.getKey()+"->");
            firstEntry.getValue().entrySet().forEach(e->{
                System.out.println(String.format("Product: %s, Price: %.1f",e.getKey(),e.getValue()));

            });

        }
    }
}
