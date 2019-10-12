import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WordSynonyms {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(reader.readLine());
        Map<String, ArrayList<String>> someMap=new LinkedHashMap<>();

        for (int i = 0; i <n; i++) {
            String key=reader.readLine();
            String value=reader.readLine();
            someMap.putIfAbsent(key,new ArrayList<>());
            someMap.get(key).add(value);



        }
        for (Map.Entry<String, ArrayList<String>>result : someMap.entrySet()) {
           String key=result.getKey();
           String value=String.join(", ",result.getValue());
            System.out.println(String.format("%s - %s",key,value));
        }
    }
}
