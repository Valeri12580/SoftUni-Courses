import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberMales = Integer.parseInt(scanner.nextLine());
        int numberFemales = Integer.parseInt(scanner.nextLine());
        int maxTables = Integer.parseInt(scanner.nextLine());
        while (true) {
            for (int j = 1; j <= numberMales; j++) {
                for (int k = 1; k <= numberFemales; k++) {
                    System.out.printf("(%d <-> %d) ", j, k);
                    maxTables--;
                    if (maxTables <= 0) {
                        return;
                    }
                    if (j == numberMales & k == numberFemales) {
                        return;
                    }


                }

            }
            return;
        }
    }

}


