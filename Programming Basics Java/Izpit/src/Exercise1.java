import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int broiAlpinisti=Integer.parseInt(scanner.nextLine());
        int broiKarabineri=Integer.parseInt(scanner.nextLine());
        int broiVajeta=Integer.parseInt(scanner.nextLine());
        int broiPikeli=Integer.parseInt(scanner.nextLine());

        double cenaKarabineri=36*broiKarabineri;
        double cenaVajeta=3.60*broiVajeta;
        double cenaPikeli=19.80*broiPikeli;

        double sumedinAlpinist=cenaKarabineri+cenaVajeta+cenaPikeli;
        double sumVsichki=broiAlpinisti*sumedinAlpinist;

        double sumDds=sumVsichki+(sumVsichki*0.20);

        System.out.printf("%.2f",sumDds);
    }
}
