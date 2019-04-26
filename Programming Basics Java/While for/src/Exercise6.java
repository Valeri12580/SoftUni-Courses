import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double spesteni = 0;
        double sum = 0;

        while (true) {
            String destination = scanner.nextLine();
            if (destination.equals("End")) {
                break;
            }
            double minimalBudjet = Double.parseDouble(scanner.nextLine());

            for (sum = 0; sum < minimalBudjet || sum <= 0; sum += spesteni) {
                spesteni = Double.parseDouble(scanner.nextLine());

            }

            System.out.println("Going to " + destination + "!");


        }

    }
}
