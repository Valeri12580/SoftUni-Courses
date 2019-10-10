import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int otsustvashtiDni=Integer.parseInt(scanner.nextLine());
        int ostavenaHranaKg=Integer.parseInt(scanner.nextLine());
        double hranaZaDenPurvoKuche=Double.parseDouble(scanner.nextLine());
        double hranaZaDenVtoroKuche=Double.parseDouble(scanner.nextLine());
        double hranaZaDenTretoKuche=Double.parseDouble(scanner.nextLine());

        double kucheEdno=hranaZaDenPurvoKuche*otsustvashtiDni;
        double kucheDve=hranaZaDenVtoroKuche*otsustvashtiDni;
        double kucheTri=hranaZaDenTretoKuche*otsustvashtiDni;

        double sum=kucheEdno+kucheDve+kucheTri;



        if (ostavenaHranaKg>=sum){
            System.out.printf("%.0f kilos of food left.",Math.floor(ostavenaHranaKg-sum));
        }else {
            System.out.printf("%.0f more kilos of food are needed.",Math.ceil(sum-ostavenaHranaKg));
        }

    }
}
