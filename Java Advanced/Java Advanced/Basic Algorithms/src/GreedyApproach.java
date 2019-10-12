import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class GreedyApproach {
    public static void main(String[] args) throws IOException {
     BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
     List<Integer> coins=Arrays.stream(reader.readLine().substring(7).split(", ")).mapToInt(Integer::parseInt).boxed()
             .collect(Collectors.toList());

       int neededSum= Integer.parseInt(reader.readLine().substring(5));


       Map<Integer,Integer>data=new LinkedHashMap<>();
       LinkedHashMap<Integer,Integer>result=greedyAlgorithm(coins,neededSum);
       int sum=0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : result.entrySet()) {
            sum+=integerIntegerEntry.getValue();


        }

        System.out.println("Number of coins to take: "+sum);
        result.entrySet().stream().forEach(e->{
           System.out.println( e.getValue()+" coin(s) with value " +e.getKey());
        });



    }

    private static LinkedHashMap<Integer, Integer> greedyAlgorithm(List<Integer> coins, int neededSum) {
        LinkedHashMap<Integer,Integer>currentResult=new LinkedHashMap<>();
        Collections.reverse(coins);
        int currentSum=0;
        int coinIndex=0;

        while (currentSum<=neededSum &&coinIndex<coins.size()){
            int currentCoin=coins.get(coinIndex);
        int remainder=neededSum-currentSum;

        int numberOfCoins=remainder/currentCoin;

        int resultFromCoins=currentCoin*numberOfCoins;

        if(resultFromCoins+currentSum<=neededSum && numberOfCoins!=0){
            currentSum+=resultFromCoins;
            currentResult.put(currentCoin,numberOfCoins);


        }
        coinIndex++;

        }

        return currentResult;

    }


}