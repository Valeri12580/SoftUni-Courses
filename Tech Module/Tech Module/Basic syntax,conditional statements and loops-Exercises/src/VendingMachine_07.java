import java.util.Scanner;

public class VendingMachine_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String startingInput = scanner.nextLine();
        double sum = 0;

        while (!startingInput.equals("Start")) {
            double input = Double.parseDouble(startingInput);
            if (input != 0.1 && input != 0.2 && input != 0.5 && input != 1 && input != 2) {
                System.out.println(String.format("Cannot accept %.2f", input));
                startingInput = scanner.nextLine();
                continue;
            } else {
                sum += input;
            }
            startingInput = scanner.nextLine();

        }
        startingInput = scanner.nextLine();


        while (!startingInput.equals("End")) {
            switch (startingInput) {
                case "Nuts":
                    sum -= 2;
                    if (sum < 0) {
                        System.out.println("Sorry, not enough money");
                        sum += 2;
                    } else {
                        System.out.println("Purchased Nuts");
                    }
                    break;
                case "Water":
                    sum -= 0.7;
                    if (sum < 0) {
                        System.out.println("Sorry, not enough money");
                        sum += 0.7;
                    } else {
                        System.out.println("Purchased Water");
                    }
                    break;
                case "Crisps":
                    sum -= 1.5;
                    if (sum < 0) {
                        System.out.println("Sorry, not enough money");
                        sum += 1.5;
                    } else {
                        System.out.println("Purchased Crisps");
                    }
                    break;
                case "Soda":
                    sum -= 0.8;
                    if (sum < 0) {
                        System.out.println("Sorry, not enough money");
                        sum += 0.8;
                    } else {
                        System.out.println("Purchased Soda");
                    }
                    break;

                case "Coke":
                    sum -= 1;
                    if (sum < 0) {
                        System.out.println("Sorry, not enough money");
                        sum += 1;
                    } else {
                        System.out.println("Purchased Coke");
                    }

                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            startingInput = scanner.nextLine();

        }
        System.out.printf("Change: %.2f",sum);




    }

}

