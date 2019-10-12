import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double tShirt=Double.parseDouble(scanner.nextLine());
        double neededSum=Double.parseDouble(scanner.nextLine());

        double priceShorti=tShirt*0.75;
        double priceChorapi=priceShorti*0.20;
        double priceButonki=(priceShorti+tShirt)*2;

        double sum=priceShorti+priceChorapi+priceButonki+tShirt;
        sum=sum-(sum*0.15);

        if(neededSum<=sum){
            System.out.printf("Yes, he will earn the world-cup replica ball!");
            System.out.println();
            System.out.printf("His sum is %.2f lv.",sum);

        }else{
            System.out.printf("No, he will not earn the world-cup replica ball.\n");
            System.out.printf("He needs %.2f lv. more.",Math.abs(sum-neededSum));
        }






    }
}
