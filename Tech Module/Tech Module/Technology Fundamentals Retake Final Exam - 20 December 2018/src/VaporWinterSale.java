import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class VaporWinterSale {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        Map<String,Double>gamesWithoutDlc=new HashMap<>();
        Map<String,Map<String,Double>>gamesWithDlc=new HashMap<>();

        String[]input=reader.readLine().split(", ");

        for (int i = 0; i <input.length; i++) {
            String[]currentGame= input[i].split("[-:]");
            String game=currentGame[0];
            if (input[i].contains("-")) {
                gamesWithoutDlc.putIfAbsent(game,Double.parseDouble(currentGame[1]));
            }else{
                String dlc=currentGame[1];
                if(gamesWithoutDlc.containsKey(game)){
                    double newPrice=gamesWithoutDlc.get(game);
                    newPrice+=(newPrice*0.20);
                    gamesWithDlc.put(game,new LinkedHashMap<>());
                    gamesWithDlc.get(game).put(dlc,newPrice);
                    gamesWithoutDlc.remove(game);


                }
            }

        }
        //games without dlc
        for (Map.Entry<String, Double> stringDoubleEntry:gamesWithoutDlc.entrySet()) {
            double newSum=stringDoubleEntry.getValue();
            newSum-=(newSum*0.20);
            gamesWithoutDlc.put(stringDoubleEntry.getKey(),newSum);

        }
        //games with dlc
        for (Map.Entry<String, Map<String, Double>> stringMapEntry : gamesWithDlc.entrySet()) {
            for (Map.Entry<String, Double> secondMap : stringMapEntry.getValue().entrySet()) {
                double newSum=secondMap.getValue();
                newSum-=(newSum*0.50);

                gamesWithDlc.put(stringMapEntry.getKey(),new TreeMap<>());
                gamesWithDlc.get(stringMapEntry.getKey()).put(secondMap.getKey(),newSum);

            }


        }
        gamesWithDlc.entrySet().forEach(e->{
            e.getValue().entrySet().forEach(j->{
                System.out.println(String.format("%s - %s - %.2f ",e.getKey(),j.getKey(),j.getValue()));
            });
        });


        gamesWithoutDlc.entrySet().stream().sorted((p1,p2)->Double.compare(p2.getValue(),p1.getValue())).forEach(e->{
            System.out.println(String.format("%s - %.2f",e.getKey(),e.getValue()));
        });



    }
}
