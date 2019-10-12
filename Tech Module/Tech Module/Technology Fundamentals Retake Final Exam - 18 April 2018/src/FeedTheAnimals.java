import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class FeedTheAnimals {
    public static void main(String[] args) throws IOException {

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        Map<String,Map<String,Integer>>result=new HashMap<>();
        Map<String,Integer>areaHungry=new HashMap<>();



        String input="";

        while (!"Last Info".equals(input=reader.readLine())){
            String []information=input.split(":");
            String command=information[0];
            String animalName=information[1];
            int food= Integer.parseInt(information[2]);
            String area=information[3];
            areaHungry.putIfAbsent(area,0);


            switch (command){
                case "Add":
                        result.putIfAbsent(animalName,new HashMap<>());
                        if(result.get(animalName).isEmpty()){
                            result.get(animalName).put(area,food);
                        }else{
                            int value=result.get(animalName).get(area)+food;
                            result.get(animalName).put(area,value);
                        }

                    break;


                case "Feed":

                    if(result.containsKey(animalName)){
                        int newValue=result.get(animalName).get(area)-food;
                        if(newValue<=0){
                            result.remove(animalName);
                            System.out.println(String.format("%s was successfully fed",animalName));
                        }else{
                            result.get(animalName).put(area,newValue);
                        }

                    }
                    break;

            }

        }
        Map<String,Integer>hungryAnimals=new TreeMap<>();
        int counter=0;
        for (Map.Entry<String, Map<String, Integer>> stringMapEntry : result.entrySet()) {


            stringMapEntry.getValue().entrySet().forEach(e->{
                hungryAnimals.put(stringMapEntry.getKey(),e.getValue());
            });

        }
        System.out.println("Animals:");
        hungryAnimals.entrySet().stream().sorted((p1,p2)->{
            int sort=Integer.compare(p2.getValue(),p1.getValue());
            if(sort==0){
                sort=p1.getKey().compareTo(p2.getKey());
                return sort;
            }
            return sort;
        }).forEach(e->{
            System.out.println(String.format("%s -> %dg",e.getKey(),e.getValue()));
        });
        System.out.println("Areas with hungry animals:");

        for (Map.Entry<String, Map<String, Integer>> resultT : result.entrySet()) {
            for (Map.Entry<String, Integer> inner : resultT.getValue().entrySet()) {
                for (Map.Entry<String, Integer> hungry : areaHungry.entrySet()) {
                    if(areaHungry.containsKey(inner.getKey())){
                        int newValue=hungry.getValue()+1;
                        areaHungry.put(hungry.getKey(),newValue);
                    }
                    break;

                }
            }

        }
        for (Map.Entry<String, Integer> stringIntegerEntry : areaHungry.entrySet()) {
            System.out.printf("%s : %d%n",stringIntegerEntry.getKey(),stringIntegerEntry.getValue());
        }





    }
}
