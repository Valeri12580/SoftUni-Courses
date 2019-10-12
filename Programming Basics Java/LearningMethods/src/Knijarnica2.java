import java.util.Scanner;

public class Knijarnica2 {

    public static void main(String[] args) {
        System.out.println("The price is: "+priceAll());

    }
    private static double priceAll(){
        double sumAll=0;
        for (double priceSum:priceForOneBook()) {
            sumAll+=priceSum;
        }
        return  sumAll;
    }

    private static double[] priceForOneBook(){
        Scanner scanner=new Scanner(System.in);
        int numBooks=Integer.parseInt(scanner.nextLine());
        double[] priceBooks=new double[numBooks];

        for (int i = 0; i < numBooks; i++) {
            priceBooks[i]=Double.parseDouble(scanner.nextLine());

        }
        return priceBooks;

    }
}
