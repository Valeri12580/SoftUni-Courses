import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int counter = 1;

        for (int j = 'B'; j <= 'L'; j+=2) {
            for (int k = 'f'; k >= 'a'; k--) {
                for (int l = 'A'; l <= 'C'; l++) {
                    for (int m = 1; m <= 10; m++) {
                        for (int o = 10; o >= 1; o--) {

                            if (n == counter) {
                                int sum=j+k+l+m+o;
                                System.out.printf("Ticket combination: %c%c%c%d%d%n", j, k, l, m, o);
                                System.out.printf("Prize: %d lv.",sum);
                                return;
                            }
                            counter++;

                        }


                    }
                }
            }
        }
    }
}
