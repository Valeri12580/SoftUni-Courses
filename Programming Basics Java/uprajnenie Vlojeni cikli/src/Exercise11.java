import java.util.Scanner;

public class Exercise11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int digitOfOnes = 0;
        int digitOfTens = 0;
        int digitOfHundreds = 0;
        int digitOfThousands = 0;
        for (int i = 1111; i <= 9999; i++) {
            digitOfThousands = i / 1000;
            digitOfHundreds = (i / 100) % 10;
            digitOfTens = (i / 10) % 10;
            digitOfOnes = i % 10;
            if (digitOfThousands == 0 || digitOfHundreds == 0 || digitOfTens == 0 || digitOfOnes == 0) {
                continue;
            }
            if (N % digitOfOnes == 0 && N % digitOfTens == 0 && N % digitOfHundreds == 0 && N % digitOfThousands == 0) {
                System.out.print(i + " ");
            }
        }
    }
}

