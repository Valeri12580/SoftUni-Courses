import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        DecimalFormat df=new DecimalFormat("#.###");

        double number=Double.parseDouble(scanner.nextLine());
        double power=Double.parseDouble(scanner.nextLine());


        System.out.println(new DecimalFormat("#.####").format(getResult(number,power)));
    }

    private static double getResult(double number,double power) {
        double result= Math.pow(number,power);
        return result;
    }
}
