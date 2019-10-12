import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        double[]prices= Arrays.stream(reader.readLine().split(", ")).mapToDouble(Double::parseDouble).toArray();
        DecimalFormat df=new DecimalFormat("#.0#");
        UnaryOperator<Double>addVat=n->n*1.2;
        System.out.println("Prices with VAT:");
        for (double price : prices) {
            System.out.printf("%.2f%n",addVat.apply(price));
        }
    }
}
