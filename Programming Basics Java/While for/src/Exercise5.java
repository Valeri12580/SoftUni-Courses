import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int counter = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    for (int l = 0; l <= n; l++) {
                        for (int m = 0; m <= n; m++) {

                            if (i + j + k + l + m == n){
                                counter++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(counter);
    }
}