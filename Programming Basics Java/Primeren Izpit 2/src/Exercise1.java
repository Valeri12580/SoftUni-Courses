import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numSectors=Integer.parseInt(scanner.nextLine());
        int capacity=Integer.parseInt(scanner.nextLine());
        double priceBilet=Double.parseDouble(scanner.nextLine());

        double pechalbaEdinSektor=(capacity*priceBilet)/numSectors;
        double obshtaPechalba=capacity*priceBilet;
        double priceBlagotvoritelnost=(obshtaPechalba-(pechalbaEdinSektor*0.75))/8;

        System.out.printf("Total income - %.2f BGN%n",obshtaPechalba);
        System.out.printf("Money for charity - %.2f BGN",priceBlagotvoritelnost);



    }
}
