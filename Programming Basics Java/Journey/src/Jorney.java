import java.util.Scanner;

public class Jorney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budjet = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        double poharchenaSuma = budjet;
        String type = "";
        String destination = "";
        if (season.equals("summer")) {
            type = "Camp";
            if (budjet <= 100) {
                destination = "Bulgaria";
                poharchenaSuma *= 0.30;
            } else if (budjet <= 1000) {
                destination = "Balkans";
                poharchenaSuma *= 0.40;
            } else if (budjet > 1000) {
                type="Hotel";
                destination = "Europe";
                poharchenaSuma *= 0.90;
            }
        }else if (season.equals("winter")){
            type="Hotel";
            if (budjet<=100){
                destination="Bulgaria";
                poharchenaSuma*=0.70;
            }else if (budjet<=1000){
                destination="Balkans";
                poharchenaSuma*=0.80;
            }else{
                destination="Europe";
                poharchenaSuma*=0.90;
            }
        }

        System.out.printf("Somewhere in %s%n",destination );
        System.out.printf("%s - %.2f",type,poharchenaSuma);


    }

}
