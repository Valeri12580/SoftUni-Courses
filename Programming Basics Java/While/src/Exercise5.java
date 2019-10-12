import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int steps = 0;
        int sum = 0;
        while (sum < 10000) {
            String type = scanner.nextLine();
            if (type.equals("Going home")) {
                steps = Integer.parseInt(scanner.nextLine());
                sum += steps;
                break;
            } else if (type.equals("Going home") && sum >= 10000) {
                steps = Integer.parseInt(scanner.nextLine());
                System.out.println("Goal reached! Good job!");
                break;

            }

            steps = Integer.parseInt(type);
            sum += steps;

        }
        if (sum >= 10000) {
            System.out.println("Goal reached! Good job!");
        }else{
            System.out.printf("%d more steps to reach goal.", 10000 - sum);
        }


    }

}
