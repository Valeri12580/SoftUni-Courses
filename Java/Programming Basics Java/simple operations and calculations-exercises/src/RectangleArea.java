import java.util.Scanner;
public class RectangleArea {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double priceWhiskey=Double.parseDouble(scanner.nextLine());
        double amountBeer=Double.parseDouble(scanner.nextLine());
        double amountVino=Double.parseDouble(scanner.nextLine());
        double amountRakia=Double.parseDouble(scanner.nextLine());
        double amountWhiskey=Double.parseDouble(scanner.nextLine());
        double priceRakia=priceWhiskey/2;
        double priceVino=priceRakia-(priceRakia*0.40);
        double priceBeer=priceRakia-(priceRakia*0.80);
        double finaleBeer=amountBeer*priceBeer;
        double finaleVino=amountVino*priceVino;
        double finaleRakia=amountRakia*priceRakia;
        double finaleWhiskey=amountWhiskey*priceWhiskey;

        double allTogheter=finaleBeer+finaleVino+finaleRakia+finaleWhiskey;

        System.out.printf("%.2f",allTogheter);








    }
}
