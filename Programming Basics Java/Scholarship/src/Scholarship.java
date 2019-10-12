import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double dohod = Double.parseDouble(scanner.nextLine());
        double sredenUspeh = Double.parseDouble(scanner.nextLine());
        double minZaplata = Double.parseDouble(scanner.nextLine());
        double cenaSocStipendiq = Math.floor(minZaplata * 0.35);
        double cenaOtlStipendiq = Math.floor(sredenUspeh * 25);
        if (sredenUspeh < 4.50) {
            System.out.println("You cannot get a scholarship!");
        } else if (sredenUspeh > 4.50 && sredenUspeh < 5.50) {
            if (dohod > minZaplata) {
                System.out.println("You cannot get a scholarship!");
            } else {
                System.out.printf("You get a Social scholarship %.0f BGN", cenaSocStipendiq);
            }

        } else if (sredenUspeh >= 5.50) {
            if (minZaplata < dohod) {
                System.out.printf("You get a scholarship for excellent results %.0f BGN", cenaOtlStipendiq);

            } else {
                if (cenaOtlStipendiq <= cenaSocStipendiq) {
                    System.out.printf("You get a Social scholarship %.0f BGN", cenaSocStipendiq);
                } else {
                    System.out.printf("You get a scholarship for excellent results %.0f BGN", cenaOtlStipendiq);
                }
            }
        }


    }


}
