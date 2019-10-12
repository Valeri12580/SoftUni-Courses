import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String sladkish=scanner.nextLine();
        int numSladkishi=Integer.parseInt(scanner.nextLine());
        int dayOfDecember=Integer.parseInt(scanner.nextLine());
        System.out.printf("%.2f",priceAfterDiscount(price(dayOfDecember,sladkish,numSladkishi),dayOfDecember));
    }

    public static double price(int day,String type,int num){
        double sum=0;
        if (day<=15){
            switch (type){
                case "Cake":
                    sum=24;
                    break;
                case "Souffle":
                    sum=6.66;
                    break;
                case "Baklava":
                    sum=12.60;
                    break;

            }
        }else{
            switch (type){
                case "Cake":
                    sum=28.70;
                    break;
                case "Souffle":
                    sum=9.80;
                    break;
                case "Baklava":
                    sum=16.98;
                    break;
            }

        }
        sum*=num;
        return sum;
    }
    public static double priceAfterDiscount(double cenaBezOtstupka,int day){
        if (day<=22) {
            if (cenaBezOtstupka >= 100 && cenaBezOtstupka <= 200) {
                cenaBezOtstupka= cenaBezOtstupka-(cenaBezOtstupka * 0.15);
            } else if (cenaBezOtstupka > 200) {
                cenaBezOtstupka = cenaBezOtstupka - (cenaBezOtstupka * 0.25);

            }
            if (day <= 15) {
                cenaBezOtstupka = cenaBezOtstupka - (cenaBezOtstupka * 0.10);
            }
        }
        return cenaBezOtstupka;

    }
}
