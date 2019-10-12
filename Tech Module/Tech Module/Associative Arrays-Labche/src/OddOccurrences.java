import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OddOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String[]input=reader.readLine().split("\\s+");

        Map<String,Integer>result=new LinkedHashMap<>();

        for (String word : input) {
            word=word.toLowerCase();
            if(result.containsKey(word)){
                result.put(word,result.get(word)+1);
            }else{
                result.put(word,1);
            }
        }

        List<String>toPrint=new ArrayList<>();

        for (Map.Entry<String, Integer> stringIntegerEntry : result.entrySet()) {
            if(stringIntegerEntry.getValue()%2==1){
                toPrint.add(stringIntegerEntry.getKey());
            }

        }
        System.out.println(toPrint.toString().replaceAll("[\\[\\]]",""));
    }
}
