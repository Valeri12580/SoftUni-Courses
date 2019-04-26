import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budjet = Double.parseDouble(scanner.nextLine());
        double sumAll = 0;
        int counterBalloons = 0;
        int counterFlowers = 0;
        int counterCandles = 0;
        int counterPandelka = 0;

        while (budjet > sumAll) {
            String stoka = scanner.nextLine();
            if (stoka.equalsIgnoreCase("stop")) {
                double moneyLeft = budjet - sumAll;
                System.out.printf("Spend money: %.2f%n", sumAll);
                System.out.printf("Money left: %.2f%n", moneyLeft);
                break;
            }
            int numberStoka = Integer.parseInt(scanner.nextLine());
            switch (stoka) {
                case "balloons":
                    sumAll += 0.10 * numberStoka;
                    counterBalloons+=numberStoka;
                    break;
                case "flowers":
                    sumAll += 1.50 * numberStoka;
                    counterFlowers+=numberStoka;
                    break;
                case "candles":
                    sumAll += 0.50 * numberStoka;
                    counterCandles+=numberStoka;
                    break;
                case "ribbon":
                    sumAll += 2 * numberStoka;
                    counterPandelka+=numberStoka;
                    break;
            }


        }
        if (budjet <= sumAll){
            System.out.println("All money is spent!");
        }

        System.out.printf("Purchased decoration is %d balloons, %d m ribbon, %d flowers and %d candles.", counterBalloons, counterPandelka, counterFlowers, counterCandles);
    }
}
