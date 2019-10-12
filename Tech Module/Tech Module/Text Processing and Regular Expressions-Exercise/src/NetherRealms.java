import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String[]input=reader.readLine().split("[,\\s]+");
        Map<String,Map<Integer,Double>>result=new TreeMap<>();
        Pattern forHealthPattern=Pattern.compile("[^\\d\\-+*\\/.]");
        for (int i = 0; i <input.length; i++) {
            String currentDemon=input[i];
            Matcher forHealthMatcher=forHealthPattern.matcher(input[i]);
            int health=0;
            while(forHealthMatcher.find()){

                    health+=forHealthMatcher.group(0).charAt(0);


            }
            result.putIfAbsent(currentDemon,new HashMap<>());
            Pattern patternDamage=Pattern.compile("[0-9-+.]+");
            Matcher matcher=patternDamage.matcher(currentDemon);

            double damage=0;
            while (matcher.find()){
                damage+=Double.parseDouble(matcher.group());
            }
            for (int j = 0; j <currentDemon.length(); j++) {
                char currentChar=currentDemon.charAt(j);
                if(currentChar=='*'){
                    damage*=2;
                }else if (currentChar=='/'){
                    damage/=2;
                }

            }

            result.get(currentDemon).put(health,damage);
        }



        result.entrySet().forEach(e->{
            e.getValue().entrySet().forEach(j->{
                double damage=j.getValue();
                System.out.println(String.format("%s - %d health, %.2f damage",e.getKey(),j.getKey(),j.getValue()));
            });
        });


    }
}
