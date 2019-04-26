import java.util.Scanner;

public class CookingMasterclass {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double budjet=Double.parseDouble(scanner.nextLine());
        int students=Integer.parseInt(scanner.nextLine());
        double priceFlour=Double.parseDouble(scanner.nextLine());
        double priceEgg=Double.parseDouble(scanner.nextLine());
        double priceApron=Double.parseDouble(scanner.nextLine());


        double freeFlour=(students/5)*priceFlour;
        double moneyForEggs=students*priceEgg*10;
        double moneyForFlour=(priceFlour*students)-freeFlour;
        double moneyForApron=(students+(Math.ceil(students*0.20)))*priceApron;

        double sum=moneyForApron+moneyForEggs+moneyForFlour;

        if(sum<=budjet){
            System.out.printf("Items purchased for %.2f$.",sum);

        }else{
            System.out.printf("%.2f$ more needed.",Math.abs(budjet-sum));
        }

    }
}
