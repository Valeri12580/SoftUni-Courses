import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int current=1;

        for (int row = 0; row <n; row++) {
            for (int j = 0; j <n ; j++) {
                current=row+j+1;
                if (current>n){
                    current=2*n-current;
                }
                System.out.print(current+" ");


            }
            System.out.println();



        }
    }
}
