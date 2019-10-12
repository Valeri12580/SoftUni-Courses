import java.util.Scanner;

public class Knijarnica {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numBooks=Integer.parseInt(scanner.nextLine());
        double sumAll=0;
        double[] priceBooks=new double[numBooks];



        for (int i = 0; i < numBooks; i++) {
            priceBooks[i]=Double.parseDouble(scanner.nextLine());

        }






        for (double singePrice:priceBooks) {
            sumAll+=singePrice;

        }

        System.out.println(sumAll);




    }
}
