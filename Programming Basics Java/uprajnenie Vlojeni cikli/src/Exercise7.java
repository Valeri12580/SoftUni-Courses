import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int prosti = 0;
        int slojni = 0;

        while (!command.equals("stop")) {
            int toInt = Integer.parseInt(command);
            if (toInt < 0) {
                System.out.println("Number is negative.");
                command = scanner.nextLine();
                continue;
            }
            int temp;
            boolean isPrime = true;
            if(toInt==1){
                isPrime=false;
            }
            for (int i = 2; i <= toInt / 2; i++) {
                temp = toInt % i;
                if (temp == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime == true) {
                prosti += toInt;
            } else {
                slojni += toInt;
            }


            command = scanner.nextLine();


        }
        System.out.printf("Sum of all prime numbers is: %d%n", prosti);

        System.out.printf("Sum of all non prime numbers is: %d", slojni);

    }




}

