import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        double priceBaklava=Double.parseDouble(scanner.nextLine());
        double priceMuffins=Double.parseDouble(scanner.nextLine());
        double kgShtolen=Double.parseDouble(scanner.nextLine());
        double kgBonboni=Double.parseDouble(scanner.nextLine());
        double kgBiskviti=Double.parseDouble(scanner.nextLine());



        double priceShtolen=priceBaklava+(priceBaklava*0.60);

        priceShtolen*=kgShtolen;

        double priceBonboni=priceMuffins+(priceMuffins*0.80);

        priceBonboni*=kgBonboni;

        double priceBiskviti=kgBiskviti*7.50;

        double sumAll=priceShtolen+priceBonboni+priceBiskviti;

        System.out.printf("%.2f",sumAll);
    }
}
