import java.math.BigDecimal;
import java.util.Scanner;

public class CentutiestoMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int centuries =Integer.parseInt(scanner.nextLine());

        int years=centuries*100;
        int days=(int)(years*365.2422);
        int hours=days*24;
        long minutes=hours*60;




        System.out.println(String.format("%d centuries = %d years = %d days = %d hours = %d minutes",centuries,years,days,hours,minutes));

    }
}


