import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int dniPrestoi=Integer.parseInt(scanner.nextLine());
        String vidPomeshtenie=scanner.nextLine();
        String ocenka=scanner.nextLine();
        double price=0;
        double namalenie=0;


        switch(vidPomeshtenie){
            case "room for one person":
                price=18;
                break;
            case "apartment":
                price+=25;
                if (dniPrestoi<10){
                    namalenie=0.30;

                }else if (dniPrestoi>=10 && dniPrestoi<=15){
                    namalenie=0.35;

                }else if (dniPrestoi>15){
                    namalenie=0.50;
                }
                break;
            case "president apartment":
                price=35;
                if (dniPrestoi<10){
                    namalenie=0.10;

                }else if (dniPrestoi>=10 && dniPrestoi<=15){
                    namalenie=0.15;

                }else if (dniPrestoi>15){
                    namalenie=0.20;
                }
                break;
        }
        int dniPrestoi2=dniPrestoi-1;
        price*=dniPrestoi2;
        price=price-(price*namalenie);

        switch (ocenka){
            case "positive":
                price=price+(price*0.25);
                break;
            case "negative":
                price=price-(price*0.10);
        }

        System.out.printf("%.2f",price);


    }
}
