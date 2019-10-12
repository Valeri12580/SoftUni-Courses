import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double priceGoing=Double.parseDouble(scanner.nextLine());
        double priceComing=Double.parseDouble(scanner.nextLine());
        double priceOneMatch=Double.parseDouble(scanner.nextLine());
        int numMatches=Integer.parseInt(scanner.nextLine());
        int discount=Integer.parseInt(scanner.nextLine());

        double totalSum=0;
        double singeSum=0;
        totalSum=(priceGoing+priceComing)*6;
        totalSum-=(totalSum*discount/100);
        totalSum+=(priceOneMatch*numMatches)*6;

        singeSum=(priceGoing+priceComing);
        singeSum-=singeSum*discount/100;

        singeSum+=numMatches*priceOneMatch;
        System.out.printf("Total sum: %.2f lv.%n",totalSum);
        System.out.printf("Each friend has to pay %.2f lv.",singeSum);


    }
}
