import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountCharsInAString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String[]input=reader.readLine().split("\\s+");

        Map<Character,Integer>result=new LinkedHashMap<>();

        for (String word:input) {
            for (char i = 0; i <word.length(); i++) {
                char alphabetic=word.charAt(i);
                result.putIfAbsent(alphabetic,0);
                result.put(alphabetic,result.get(alphabetic)+1);

            }


        }
        for (Map.Entry<Character, Integer> kvp : result.entrySet()) {
            System.out.println(String.format("%c -> %d",kvp.getKey(),kvp.getValue()));
        }


    }
}
