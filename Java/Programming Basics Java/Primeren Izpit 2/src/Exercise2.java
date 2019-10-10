import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();
        double budjet=Double.parseDouble(scanner.nextLine());
        int numBeer=Integer.parseInt(scanner.nextLine());
        int numChips=Integer.parseInt(scanner.nextLine());




        double sumBeer=numBeer*1.20;
        double sumChips=Math.ceil(numChips*(sumBeer*0.45));

        double sumAll=sumBeer+sumChips;

        if (budjet>=sumAll){
            System.out.printf("%s bought a snack and has %.2f leva left.",name,budjet-sumAll);
        }else{
            System.out.printf("%s needs %.2f more leva!",name,sumAll-budjet);
        }



    }
}
