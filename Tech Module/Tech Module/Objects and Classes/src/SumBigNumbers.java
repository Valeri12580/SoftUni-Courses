import java.math.BigDecimal;
import java.util.Scanner;

public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        BigDecimal inputOne=new BigDecimal(scanner.nextLine());
        BigDecimal inputTwo=new BigDecimal(scanner.nextLine());

        BigDecimal result=inputOne.add(inputTwo);
        System.out.println(result);
    }
}
