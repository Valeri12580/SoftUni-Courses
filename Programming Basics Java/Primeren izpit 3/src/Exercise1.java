import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double priceGoing=Double.parseDouble(scanner.nextLine());
        double priceComing=Double.parseDouble(scanner.nextLine());
        double priceOneMatch=Double.parseDouble(scanner.nextLine());
        int numMatches=Integer.parseInt(scanner.nextLine());
        int percentOtstupka=Integer.parseInt(scanner.nextLine());


        double priceTravelling=((priceGoing+priceComing)*6);
        priceTravelling=priceTravelling-(priceTravelling*percentOtstupka/100);

        double priceMatches=(priceOneMatch*numMatches)*6;
        double priceAll=priceTravelling+priceMatches;
        double pricePerFriend=priceAll/6;

        System.out.printf("Total sum: %.2f lv.%n",priceAll);
        System.out.printf("Each friend has to pay %.2f lv.",pricePerFriend);

    }
}
