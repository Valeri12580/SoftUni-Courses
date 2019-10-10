import java.util.Scanner;

public class WhileExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int badScore = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        double averageOcenka = 0;
        int broinaZadachi = 0;
        String lastProblem="";

        while (true) {
            String predmet = scanner.nextLine();
            if (predmet.equals("Enough")) {
                averageOcenka = averageOcenka / broinaZadachi;
                System.out.printf("Average score: %.2f\n", averageOcenka);
                System.out.printf("Number of problems: %d\n", broinaZadachi);
                System.out.printf("Last problem: %s\n", lastProblem);
                break;
            }
            int ocenka = Integer.parseInt(scanner.nextLine());
            broinaZadachi++;
            averageOcenka += ocenka;
            lastProblem=predmet;
            if (ocenka <= 4) {
                ++counter;
            }
            if (badScore == counter) {
                System.out.printf("You need a break, %d poor grades.", counter);
                break;


            }

        }
    }
}