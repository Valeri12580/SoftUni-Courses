import java.util.Scanner;

public class PartyProfit {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int partySize=Integer.parseInt(scanner.nextLine());
        int days=Integer.parseInt(scanner.nextLine());
        double balance=0;
        for (int i =1; i <=days; i++) {
            balance+=50;
            if(i%10==0){
                partySize-=2;
            }
            if(i%15==0){
                partySize+=5;

            }

            balance-=2*partySize;
            if(i%3==0){
                balance-=partySize*3;
            }
            if(i%5==0){
                balance+=20*partySize;
                if(i%3==0){
                    balance-=2*partySize;
                }

            }




        }
        System.out.println(String.format("%d companions received %.0f coins each.",partySize,Math.floor(balance/partySize)));


    }
}
