import java.util.Scanner;
public class ShoppingTime {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int pochivka=Integer.parseInt(scanner.nextLine());
        int ostavashtoVreme=pochivka-5-(6+4);
        double cenaPeriferiq=Double.parseDouble(scanner.nextLine());
        double cenaFinal=cenaPeriferiq*3;
        double cenaPrograma=Double.parseDouble(scanner.nextLine());
        double programaFinal=cenaPrograma*2;
        double cenaFrape=Double.parseDouble(scanner.nextLine());
        double finale = cenaFinal+programaFinal+cenaFrape;
        System.out.printf("%.2f \n",finale);
        System.out.print(ostavashtoVreme);
    }
}
