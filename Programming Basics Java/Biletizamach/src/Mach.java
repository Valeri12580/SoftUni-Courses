import java.util.Scanner;

public class Mach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budjet = Double.parseDouble(scanner.nextLine());
        String caterogy = scanner.nextLine();
        int people = Integer.parseInt(scanner.nextLine());
        double transport = 0;
        double remaining=0;
        double priceCat=0;

        if (people >= 1 && people <= 4) {
            transport = budjet * 0.75;
        } else if (people >= 5 && people <= 9) {
            transport = budjet * 0.60;
        } else if (people >= 10 && people <= 24) {
            transport = budjet * 0.50;
        } else if (people >= 25 && people <= 49) {
            transport = budjet * 0.40;
        } else if (people >= 50) {
            transport = budjet * 0.25;
        }
        remaining=budjet-transport;
        switch (caterogy){
            case "VIP":
                priceCat=499.99*people;
                break;
            case "Normal":
                priceCat=249.99*people;
                break;

        }
        if (remaining>=priceCat){
            System.out.printf("Yes! You have %.2f leva left.",remaining-priceCat);
        }else{
            System.out.printf("Not enough money! You need %.2f leva.",priceCat-remaining);
        }


    }

}