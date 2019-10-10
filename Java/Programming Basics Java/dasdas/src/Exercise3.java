import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        double n=3.3023132000;
        DecimalFormat df=new DecimalFormat("#.###");



        System.out.println(df.format(n));
        System.out.println(n);
    }
}
