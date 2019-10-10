package CardsWithPower;

public class Cards {




    public static void returnSum(String rank,String suit){
        int sum=0;
        sum=RankPowers.valueOf(rank).getValue()+SuitPowers.valueOf(suit).getValue();
        System.out.printf("Card name: %s of %s; Card power: %d",rank,suit,sum);

    }

}
