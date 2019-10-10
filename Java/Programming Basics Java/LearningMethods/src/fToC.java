import java.util.Scanner;

public class fToC {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Въведи число в Фаренхайт:");
        double farenhait=Double.parseDouble(scanner.nextLine());
        double result=toCelsium(farenhait);
        System.out.printf("Your body temperature in Celsius degrees is %f.%n",result);
        if (result>37){
            System.out.println("You are ill!");
        }

    }


    public static double toCelsium(double farenhait) {
        double formulaC=(farenhait-32)*5/9;
        return formulaC;

    }

}
