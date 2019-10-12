import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HuntingGames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int  daysOfAdventure=Integer.parseInt(reader.readLine());
        int countPlayers=Integer.parseInt(reader.readLine());
        double groupEnergy=Double.parseDouble(reader.readLine());
        double waterPerDayForOnePerson=Double.parseDouble(reader.readLine());
        double foodPerDayForOnePerson=Double.parseDouble(reader.readLine());

        double waterForAll=countPlayers*waterPerDayForOnePerson*daysOfAdventure;
        double foodForAll=countPlayers*foodPerDayForOnePerson*daysOfAdventure;


        for (int i = 1; i <=daysOfAdventure; i++) {
            Double energyLossChoppingWood=Double.parseDouble(reader.readLine());
            groupEnergy-=energyLossChoppingWood;
            if (groupEnergy<=0){
                System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.",foodForAll,waterForAll);

                return;
            }
            if(i%2==0){
                groupEnergy=groupEnergy+(groupEnergy*5/100);
                waterForAll=waterForAll-(waterForAll*0.30);
            }
            if(i%3==0){
                foodForAll=foodForAll-(foodForAll/countPlayers);
                groupEnergy+=(groupEnergy*0.10);

            }

        }

        System.out.printf("You are ready for the quest. You will be left with - %.2f energy!",groupEnergy);

    }
}
