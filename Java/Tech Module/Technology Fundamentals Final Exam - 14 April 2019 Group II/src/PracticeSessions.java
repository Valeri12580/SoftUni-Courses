import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PracticeSessions {
    public static void main(String[] args) throws IOException {

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>>results=new TreeMap<>();

        String input="";


        while (!("END").equals(input=reader.readLine())){
            String[] split=input.split("->");
            String command=split[0];
            String road_CurrentRoad=split[1];
            switch (command){
                case "Add":
                    String racer=split[2];
                    results.putIfAbsent(road_CurrentRoad,new ArrayList<>());
                    results.get(road_CurrentRoad).add(racer);
                    boolean isContained=results.get(road_CurrentRoad).contains(racer);

                    break;

                case "Move":
                    String movedRacer=split[2];
                    String nextRoad=split[3];
                    if(results.get(road_CurrentRoad).contains(movedRacer)){
                        results.get(nextRoad).add(movedRacer);
                        results.get(road_CurrentRoad).remove(movedRacer);
                    }


                    break;

                case "Close":
                    results.remove(road_CurrentRoad);

                    break;
            }


        }
        System.out.println("Practice sessions:");

        results.entrySet().stream().sorted((p1,p2)->{
            int comp=Integer.compare(p2.getValue().size(),p1.getValue().size());
            if(comp==0){
                comp=p1.getKey().compareTo(p2.getKey());
                return comp;
            }
            return comp;
        }).forEach(e->{
            System.out.println(String.format("%s",e.getKey()));
            for (int i = 0; i <e.getValue().size(); i++) {
                System.out.println(String.format("++%s",e.getValue().get(i)));
            }

        });
    }
}
