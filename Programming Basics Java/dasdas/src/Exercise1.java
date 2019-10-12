import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int sum = 0;
        int maxNum = Integer.MIN_VALUE;

        String winner = "";
        while (!name.equals("Stop")) {
            int length = name.length();
            for (int i = 0; i < length; i++) {
                char charakter = name.charAt(i);
                sum += charakter;


            }
            if (sum > maxNum) {
                winner = name;
                maxNum = sum;


            }

            name = scanner.nextLine();
            sum = 0;

        }
        System.out.println(winner);
        System.out.println(maxNum);


    }
}
