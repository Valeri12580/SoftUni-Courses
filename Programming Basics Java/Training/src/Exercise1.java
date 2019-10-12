import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double duljina=Double.parseDouble(scanner.nextLine());
        double shirina=Double.parseDouble(scanner.nextLine());
        double stranaBar=Double.parseDouble(scanner.nextLine());

        double obemnaZala=duljina*shirina;
        stranaBar*=stranaBar;
         obemnaZala=obemnaZala-(obemnaZala*0.19);
        obemnaZala-=stranaBar;

        double pobirashtiSe=Math.ceil(obemnaZala/3.2);

        System.out.printf("%.0f",pobirashtiSe);



    }
}
