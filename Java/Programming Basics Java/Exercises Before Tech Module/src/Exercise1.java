import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numHimicals=Integer.parseInt(scanner.nextLine());
        int numMarkers=Integer.parseInt(scanner.nextLine());
        Double lPreparat=Double.parseDouble(scanner.nextLine());
        int percentDiscount=Integer.parseInt(scanner.nextLine());

        double priceHimicals=numHimicals*5.80;
        double priceMarkers=numMarkers*7.20;
        double pricePreparat=lPreparat*1.20;
        double all=priceHimicals+priceMarkers+pricePreparat;

        all=all-(all*percentDiscount/100);
        System.out.printf("%.3f",all);
    }
}
