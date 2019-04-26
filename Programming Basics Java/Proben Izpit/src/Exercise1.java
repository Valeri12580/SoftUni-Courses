import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Double moneyFood=Double.parseDouble(scanner.nextLine());
        Double priceSuvenir=Double.parseDouble(scanner.nextLine());
        Double priceHotel=Double.parseDouble(scanner.nextLine());
        double otstupka=10;


        double cenalitri=1.85*(420.0/100*7);
         moneyFood=moneyFood*3;
         priceSuvenir*=3;
         double pricehotel1=priceHotel-(priceHotel*0.10);
        double pricehotel2=priceHotel-(priceHotel*0.15);
        double pricehotel3=priceHotel-(priceHotel*0.20);

        double sumAll=cenalitri+moneyFood+priceSuvenir+pricehotel1+pricehotel2+pricehotel3;
        System.out.printf("Money needed: %.2f",sumAll);






    }
}
