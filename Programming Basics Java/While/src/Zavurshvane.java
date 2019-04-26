import java.util.Scanner;

public class Zavurshvane {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        double sum = 0;
        double uspeh = 0;
        int count = 1;
        while (count <= 12) {
            double ocenka = Double.parseDouble(scanner.nextLine());
            if (ocenka >= 4.00) {
                sum = sum + ocenka;
                ++count;

            }

        }
        uspeh = sum / 12;


        System.out.printf("%s graduated. Average grade: %.2f", name, uspeh);

    }
}
