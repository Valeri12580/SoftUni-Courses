import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double neededMoney = Double.parseDouble(scanner.nextLine());
        Double avalibleMoney = Double.parseDouble(scanner.nextLine());
        int counter = 0;
        int spendCounter = 0;
        while (neededMoney > avalibleMoney) {
            String command = scanner.nextLine();
            Double commandMoney = Double.parseDouble(scanner.nextLine());
            if (command.equals("save")) {
                avalibleMoney += commandMoney;
                spendCounter=0;
            } else if (command.equals("spend")) {
                avalibleMoney -= commandMoney;
                spendCounter++;
            }
            counter++;
            if (avalibleMoney<0){
                 avalibleMoney=0.0;
            }
            if (spendCounter==5) {
                break;
            }
        }

        if (avalibleMoney >= neededMoney) {
            System.out.printf("You saved the money for %d days.", counter);
        } else if (spendCounter == 5) {
            System.out.printf("You can't save the money.%n");
            System.out.printf("%d", counter);
        }
    }
}
