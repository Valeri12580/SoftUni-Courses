import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BreadFactory {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String[]input=reader.readLine().split("\\|");
        int energy=100;
        int coins=100;



        for (int i = 0; i <input.length; i++) {
            String[]currentEvent=input[i].split("-+");
            String firstPosition=currentEvent[0];
            int secondPosition= Integer.parseInt(currentEvent[1]);

            if(firstPosition.equals("rest")){
                if(energy+secondPosition<=100){
                    energy+=secondPosition;
                    System.out.println(String.format("You gained %d energy.",secondPosition));
                }else{
                    int gainedEnergy=100-energy;
                    energy+=gainedEnergy;
                    System.out.println(String.format("You gained %d energy.",gainedEnergy));
                }
                System.out.println(String.format("Current energy: %d.",energy));
            }else if (firstPosition.equals("order")){
                energy-=30;
                if(energy>=0){
                    coins+=secondPosition;
                    System.out.printf("You earned %d coins.%n",secondPosition);
                }else{
                    energy+=80;
                    System.out.println("You had to rest!");

                }
            }else{
                coins-=secondPosition;
                if(coins<=0){
                    System.out.printf("Closed! Cannot afford %s.",firstPosition);
                    return;

                }else{
                    System.out.printf("You bought %s.%n",firstPosition);
                }
            }

        }
        System.out.printf("Day completed!%nCoins: %d%nEnergy: %d",coins,energy);




    }
}
