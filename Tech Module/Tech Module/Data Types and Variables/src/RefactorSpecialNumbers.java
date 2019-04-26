import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        boolean isSpecial = false;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int i2 = i;
            while (i2 > 0) {
                sum += i2 % 10;
                i2 = i2 / 10;
            }
            isSpecial = (sum == 5) || (sum == 7) || (sum == 11);
            if (isSpecial) {
                System.out.printf("%d -> True%n", i);
            }else{
                System.out.printf("%d -> False%n", i);
            }

            

        }




    }
}
