import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dictionary {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<String>>result=new TreeMap<>();


        for (int i = 1; i <=3; i++) {
            String[] input=reader.readLine().split(" \\| ");
            if(i==1){
                for (int j = 0; j <input.length; j++) {
                    String[]currentWord=input[j].split(": ");
                    result.putIfAbsent(currentWord[0],new ArrayList<>());
                    result.get(currentWord[0]).add(currentWord[1]);

                }
            }
            if(i==2){
                for (int j = 0; j <input.length; j++) {
                    String currentWord=input[j];

                    if (result.containsKey(currentWord)) {
                        System.out.printf("%s%n",currentWord);
                        result.get(currentWord).stream().sorted((p1,p2)->Integer.compare(p2.length(),p1.length())).forEach(e->{
                            System.out.printf("-%s%n",e);
                        });

                    }


                }

            }
            if(i==3){
                if(input[0].equals("End")){
                    return;
                }else if (input[0].equals("List")){
                    for (Map.Entry<String, List<String>> stringListEntry : result.entrySet()) {
                        System.out.print(stringListEntry.getKey()+" ");

                    }

                }

            }



        }
    }
}
