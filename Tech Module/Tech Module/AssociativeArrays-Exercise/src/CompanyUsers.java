import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CompanyUsers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String[]input=reader.readLine().split("\\s+");
        Map<String, List<String>>data=new TreeMap<>();

        while(!input[0].equals("End")){
            String companyName=input[0];
            String employerName=input[2];
            data.putIfAbsent(companyName,new ArrayList<>());
            if(!data.get(companyName).contains(employerName)){
                data.get(companyName).add(employerName);
            }
            input=reader.readLine().split("\\s+");


        }
        data.entrySet().forEach(e-> {
            System.out.println(String.format("%s",e.getKey()));
            e.getValue().forEach(v->System.out.printf("-- %s%n",v));
        });
    }
}
