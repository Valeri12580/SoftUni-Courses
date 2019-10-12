import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class MultiplyBigNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        BigDecimal result=new BigDecimal("0");

        BigDecimal inputOne=new BigDecimal(reader.readLine());
        int inputTwo=Integer.parseInt(reader.readLine());

        result=result.add(inputOne);
        result=result.multiply(BigDecimal.valueOf(inputTwo));
        System.out.println(result);
    }
}
