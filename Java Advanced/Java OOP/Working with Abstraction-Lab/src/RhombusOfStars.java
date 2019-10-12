import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =Integer.parseInt(scanner.nextLine());
        printUpperRow(n);
        printLowerRow(n);





    }

    public static void printUpperRow(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = n-i; j >0 ; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <i ; j++) {

                System.out.print("*");
                if(j!=i-1){
                    System.out.print(" ");
                }
            }
            System.out.println();

        }
    }

    public static void printLowerRow(int n){
        for (int i = n-1; i > 0; i--) {
            for (int j = 0; j <n-i ; j++) {
                System.out.print(" ");
            }
            for (int j = i; j>0 ; j--) {
                System.out.print("*");
                if(j!=1){
                    System.out.print(" ");
                }

            }
            System.out.println();

        }
    }
}
