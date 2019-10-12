import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        double[]input=Arrays.stream(reader.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        Map<Double,Integer> someMap=new TreeMap<>();

        for (Double num:input) {
            if(!someMap.containsKey(num)){
                someMap.put(num,0);
            }

            if(someMap.containsKey(num)){
                someMap.put(num,someMap.get(num)+1);
            }
        }
        for (Map.Entry<Double,Integer>printed:someMap.entrySet()) {
            System.out.println(new DecimalFormat("#.#######").format(printed.getKey())+ " -> "+printed.getValue());
        }




    }
}
