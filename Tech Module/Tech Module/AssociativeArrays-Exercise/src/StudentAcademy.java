import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class StudentAcademy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt (reader.readLine());
        Map<String,List<Double>>data=new LinkedHashMap<>();


        for (int i = 0; i <n; i++) {
            String name=reader.readLine();
            double grade= Double.parseDouble(reader.readLine());
            data.putIfAbsent(name,new ArrayList());
            data.get(name).add(grade);



        }
        Map<String,Double>result=new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> kvp : data.entrySet()) {
            double average=0;
            for (int i = 0; i <kvp.getValue().size(); i++) {
                    average+=kvp.getValue().get(i);

            }
            average=average/kvp.getValue().size();
            if(average>=4.50){
                result.put(kvp.getKey(),average);

            }


        }


       result.entrySet().stream().sorted((p1,p2)->p2.getValue().compareTo(p1.getValue())).forEach(e->System.out.println(String.format("%s -> %.2f",e.getKey(),e.getValue())));


    }
}
