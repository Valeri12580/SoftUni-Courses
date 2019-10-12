import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double recordInSeconds = Double.parseDouble(scanner.nextLine());
        double raztoqnieVMetri = Double.parseDouble(scanner.nextLine());
        double vremeIzkachvane1M = Double.parseDouble(scanner.nextLine());

        double nujnisekundi = raztoqnieVMetri * vremeIzkachvane1M;
        double kolkoputiGoeZabavil = Math.floor(raztoqnieVMetri / 50);
        kolkoputiGoeZabavil *= 30;

        nujnisekundi += kolkoputiGoeZabavil;


        if (recordInSeconds >= nujnisekundi) {
            System.out.printf("Yes! The new record is %.2f seconds.", nujnisekundi);
        } else {
            System.out.printf("No! He was %.2f seconds slower.", nujnisekundi - recordInSeconds);
        }
    }
}
