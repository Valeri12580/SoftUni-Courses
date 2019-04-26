import java.util.Scanner;

public class ConvertMeterstoKilometers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int meters=Integer.parseInt(scanner.nextLine());

        double toKm=meters/(double)1000;
        System.out.printf("%.2f",toKm);
    }
}
