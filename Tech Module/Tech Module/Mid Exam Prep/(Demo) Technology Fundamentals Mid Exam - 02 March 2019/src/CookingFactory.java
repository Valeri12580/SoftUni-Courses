import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CookingFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("#");
        int bestQuality = Integer.MIN_VALUE;
        double bestAverage = Double.MIN_VALUE;
        String winner = "";


        while (!input[0].equals("Bake It!")) {
            int[] numbers = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                sum += numbers[i];
            }

            double average = sum * 1.0 / numbers.length;

            if (sum > bestQuality) {
                bestQuality = sum;
                winner = "";
                for (int n : numbers) {

                    winner += n + " ";
                }

            }
            if (sum == bestQuality) {
                if (average > bestAverage) {
                    bestAverage = average;
                    winner = "";
                    for (int n : numbers) {

                        winner += n + " ";
                    }

                }
            }

            input = scanner.nextLine().split("#");

        }
        System.out.println(String.format("Best Batch quality: %d", bestQuality));
        System.out.println(winner);
    }
}

