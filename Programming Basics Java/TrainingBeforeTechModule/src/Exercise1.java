import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceWhiskey = Double.parseDouble(scanner.nextLine());
        double kolichestvoVoda = Double.parseDouble(scanner.nextLine());
        double kolichestvoVino = Double.parseDouble(scanner.nextLine());
        double kolichestvoShampansko = Double.parseDouble(scanner.nextLine());
        double kolichestvoUiski = Double.parseDouble(scanner.nextLine());

        double priceShampansko=priceWhiskey-(priceWhiskey*0.50);
        double priceVino=priceShampansko-(priceShampansko*0.60);
        double priceWater=priceShampansko-(priceShampansko*0.90);

        double sum=(priceWhiskey*kolichestvoUiski)+(kolichestvoVoda*priceWater)+(kolichestvoVino*priceVino)+(kolichestvoShampansko*priceShampansko);
        System.out.printf("%.2f",sum);


    }

}
