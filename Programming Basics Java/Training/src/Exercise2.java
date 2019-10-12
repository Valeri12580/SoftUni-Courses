import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numberGuests=Integer.parseInt(scanner.nextLine());
        double budjet=Double.parseDouble(scanner.nextLine());


        double neededSum=numberGuests*20;

        double diff=budjet-neededSum;

        if (diff<0){
            System.out.printf("They won't have enough money to pay the covert. They will need %d lv more.",Math.round(Math.abs(diff)));
        }else if (diff>0){
            double priceFireworks=(diff*40)/100;
            double donate=diff-priceFireworks;
            System.out.printf("Yes! %d lv are for fireworks and %d lv are for donation.",Math.round(priceFireworks),Math.round(donate));


        }
    }
}
