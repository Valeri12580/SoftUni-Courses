import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class SoftuniExamResults {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String command="";
        Map<String,Integer>result=new TreeMap<>();
        Map<String,Integer>submitions=new TreeMap<>();

        while (!"exam finished".equals(command=reader.readLine())){
            String[] commandToArray=command.split("-");
            String username=commandToArray[0];
            String language=commandToArray[1];

            if(language.equals("banned")){
                result.remove(username);
                continue;
            }
            int poins= Integer.parseInt(commandToArray[2]);
           if(!result.containsKey(username)){
               result.put(username,poins);
           }
           if(result.get(username)<poins){
               result.put(username,poins);
           }


                submitions.putIfAbsent(language,0);
                submitions.put(language,submitions.get(language)+1);

        }
        System.out.println("Results:");

        result.entrySet().stream().sorted((p1,p2)->Integer.compare(p2.getValue(),p1.getValue())).forEach(e-> System.out.printf("%s | %d%n",e.getKey(),e.getValue()));
        System.out.println("Submissions:");
        submitions.entrySet().stream().sorted((p1,p2)->Integer.compare(p2.getValue(),p1.getValue())).forEach(e-> System.out.printf("%s - %d%n",e.getKey(),e.getValue()));

    }
}
