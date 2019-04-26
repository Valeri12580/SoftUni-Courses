import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num1=Integer.parseInt(scanner.nextLine());
        printResult(num1);



    }

    static void printResult(int num1){
        for (int i = 0; i <num1; i++) {
            for (int j = 0; j <num1; j++) {
                System.out.print(num1+" ");
            }
            System.out.println();
        }
    }
}
