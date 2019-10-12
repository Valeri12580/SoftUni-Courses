import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double priceShirt=Double.parseDouble(scanner.nextLine());
        double neededSum=Double.parseDouble(scanner.nextLine());

        double shorts=priceShirt*0.75;
        double socks=shorts*0.20;
        double shoes=(shorts+priceShirt)*2;

        double discount=(shorts+socks+shoes+priceShirt);
        discount=discount-(discount*0.15);

        if (neededSum<=discount){
            System.out.println("Yes, he will earn the world-cup replica ball!");
            System.out.printf("His sum is %.2f lv.",discount);
        }else{
            System.out.println("No, he will not earn the world-cup replica ball.");
            System.out.printf("He needs %.2f lv. more.",neededSum-discount);
        }
    }
}
