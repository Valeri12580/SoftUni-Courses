import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class SoftuniParking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(reader.readLine());
        Map<String,String>database=new LinkedHashMap<>();


        for (int i = 0; i <n; i++) {
            String[]input =reader.readLine().split("\\s+");
            String command=input[0];
            String name=input[1];


            switch (command){
                case "register":
                    String number=input[2];
                        if(database.containsKey(name)){
                            System.out.println(String.format("ERROR: already registered with plate number %s",number));
                        }else{
                            database.put(name,number);
                            System.out.printf("%s registered %S successfully%n",name,number);

                        }

                    break;

                case "unregister":
                    if(database.containsKey(name)){
                        database.remove(name);
                        System.out.printf("%s unregistered successfully%n",name);

                    }else{
                        System.out.println(String.format("ERROR: user %s not found",name));
                    }

                    break;

            }

        }
        for (Map.Entry<String, String> stringStringEntry : database.entrySet()) {
            System.out.println(stringStringEntry.getKey()+ " => "+stringStringEntry.getValue());

        }
    }
}
