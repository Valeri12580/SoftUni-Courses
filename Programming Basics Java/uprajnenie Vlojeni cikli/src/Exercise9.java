import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double sum = 0;
        double sumbez3 = 0;
        double overallSum = 0;
        int overallCount = 0;
        boolean kvota = true;

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();

            if (name.equals("Stop")) {
                kvota = false;
                break;
            }
            boolean isTrue = true;

            overallCount++;
            Double kg = Double.parseDouble(scanner.nextLine());

            for (int j = 0; j < name.length(); j++) {
                char bukva = name.charAt(j);
                if (overallCount % 3 == 0) {
                    sumbez3 += bukva;
                    isTrue = false;
                }
                sum += bukva;

            }
            if (isTrue) {
                sum /= kg;
                overallSum += sum;
            } else {
                sumbez3 /= kg;

            }
            sum = 0;


        }

        if (kvota == true) {
            System.out.println("Lyubo fulfilled the quota!");
        }
        if (sumbez3 >= overallSum) {
            System.out.printf("Lyubo's profit from %d fishes is %.2f leva.", overallCount, sumbez3 - overallSum);
        } else {
            System.out.printf("Lyubo lost %.2f leva today.", Math.abs(sumbez3 - overallSum));
        }


    }
}
