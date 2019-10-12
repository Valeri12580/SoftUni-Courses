import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double shirochinaKorab=Double.parseDouble(scanner.nextLine());
        double duljinaKorab=Double.parseDouble(scanner.nextLine());
        double visochinaKorab=Double.parseDouble(scanner.nextLine());
        double visochinaAstronavti=Double.parseDouble(scanner.nextLine());

        double obem=shirochinaKorab*duljinaKorab*visochinaKorab;
        double nujdi=(visochinaAstronavti+0.40)*4;
        double broiAstronavti=Math.floor(obem/nujdi);

        if (broiAstronavti<3){
            System.out.println("The spacecraft is too small.");

        }else if (broiAstronavti>=3 && broiAstronavti<=10){
            System.out.printf("The spacecraft holds %.0f astronauts.",broiAstronavti);
        }else{
            System.out.println("The spacecraft is too big.");
        }


    }
}
