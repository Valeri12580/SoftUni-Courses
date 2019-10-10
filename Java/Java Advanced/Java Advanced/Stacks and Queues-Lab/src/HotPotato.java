import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class HotPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        List<String> names=Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());

        ArrayDeque<String>dataQueue=new ArrayDeque<>();
        dataQueue.addAll(names);
        int n=Integer.parseInt(reader.readLine());


        while (dataQueue.size()!=1){

            for (int i = 1; i <n; i++) {
                String last=dataQueue.poll();
                dataQueue.offer(last);

            }
            System.out.println("Removed "+dataQueue.peek());
            dataQueue.poll();


        }
        System.out.println("Last is "+dataQueue.toString().replaceAll("[\\[\\]]",""));
    }
}
