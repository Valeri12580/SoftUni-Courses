import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AMinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        Map<String,Integer> result=new LinkedHashMap<>();
        List<String>key=new ArrayList<>();
        List<Integer>value=new ArrayList<>();

        int counter=1;
        String command="";
        while (!"stop".equals(command=reader.readLine())) {
            if (counter % 2 == 1) {
                key.add(command);

            }else{
                value.add(Integer.parseInt(command));
            }
            counter++;
        }

        for (int i = 0; i <key.size(); i++) {
            String kliuch=key.get(i);
            int stoinost=value.get(i);
            if(!result.containsKey(kliuch)){
                result.put(kliuch,stoinost);

            }else{
                int oldValue=result.get(kliuch);
                result.put(kliuch,oldValue+stoinost);
            }

            
        }

        result.entrySet().forEach(e->{
            System.out.println(String.format("%s -> %d",e.getKey(),e.getValue()));
        });

    }
}
