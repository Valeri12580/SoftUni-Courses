import java.util.Scanner;

public class FactorialDevision {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int  n1=Integer.parseInt(scanner.nextLine());
        int n2=Integer.parseInt(scanner.nextLine());
        if (n1==0 || n2==0){
            System.out.println("0.00");
            return;
        }
        double result=getFactorial(n1)/getFactorial(n2);
        System.out.println(String.format("%.2f",result));





    }

    static double getFactorial(int n){
        String number=""+n;
        double factorial=1;
        for (long i = n; i >0; i--) {
            factorial*=i;

        }
        return factorial;

    }
}
