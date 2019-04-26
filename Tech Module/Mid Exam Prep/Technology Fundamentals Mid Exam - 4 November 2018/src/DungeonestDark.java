import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DungeonestDark {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String[]input=reader.readLine().split("\\|");


        int health=100;
        int coins=0;

        for (int i = 0; i < input.length; i++) {
            String[]currentRoom=input[i].split(" ");
            String firstPart=currentRoom[0];
            int number=Integer.parseInt(currentRoom[1]);
             if(currentRoom[0].equals("potion")){
                 if(health+number<=100){
                     health+=number;
                     System.out.println(String.format("You healed for %d hp.",number));
                 }else{
                     int healedNumber=100-health;
                     health+=healedNumber;
                     System.out.println(String.format("You healed for %d hp.",healedNumber));

                 }
                 System.out.printf("Current health: %d hp.%n",health);

             }else if (firstPart.equals("chest")){
                 coins+=number;
                 System.out.printf("You found %d coins.%n",number);
             }else{
                 health-=number;
                 if(health<=0){
                     System.out.printf("You died! Killed by %s.%n",firstPart);
                     System.out.printf("Best room: %d",i+1);
                     return;
                 }else{
                     System.out.println(String.format("You slayed %s.",firstPart));
                 }
             }




        }
        System.out.printf("You've made it!%nCoins: %d%nHealth: %d",coins,health);

    }
}
