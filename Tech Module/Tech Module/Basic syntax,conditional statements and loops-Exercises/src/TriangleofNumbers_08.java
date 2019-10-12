import java.util.Scanner;

public class TriangleofNumbers_08 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());



        for (int rows = 1; rows <=n; rows++) {
            for (int i = 1; i <=rows ; i++) {
                System.out.print(rows+" ");

            }

            System.out.println();
        }
    }
}
