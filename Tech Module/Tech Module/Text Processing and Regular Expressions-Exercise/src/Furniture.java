import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        Map<String,Double>price=new LinkedHashMap<>();
        Pattern pattern=Pattern.compile("^>>(?<Product>[A-Za-z]+)<<(?<price>\\d+\\.*\\d+)!(?<quantity>\\d+)\\s");
        String command="";
        double totalPrice=0;

        while(!"Purchase".equals(command=reader.readLine())){
            Matcher matcher=pattern.matcher(command);

            if(matcher.find()){
                double sum=Double.parseDouble(matcher.group("price"))*Double.parseDouble(matcher.group("quantity"));
                totalPrice+=sum;
                price.put(matcher.group("Product"),sum);
            }
        }
        System.out.println("Bought furniture:");
        price.entrySet().forEach(e->{
            System.out.println(e.getKey());
        });
        System.out.println(String.format("Total money spend: %.2f",totalPrice));

    }
}
