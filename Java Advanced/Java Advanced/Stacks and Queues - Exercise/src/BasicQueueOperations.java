import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;

public class BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int[]command= Arrays.stream(reader.readLine().split(" ")).mapToInt((e)->Integer.parseInt(e)).toArray();
        ArrayDeque<Integer>queue=new ArrayDeque<>();
        int[]numbers= Arrays.stream(reader.readLine().split(" ")).mapToInt((e)->Integer.parseInt(e)).toArray();


        Arrays.stream(numbers).forEach(e->queue.offer(e));
        for (int i = 0; i <command[1]; i++) {
            queue.poll();

        }

        if(queue.contains(command[2])){
            System.out.println("true");
        }else if(queue.size()==0){
            System.out.println("0");
        }else{
            System.out.println(Collections.min(queue));
        }

    }
}
