import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class RecursiveFibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        long n= Long.parseLong(reader.readLine());
        ArrayDeque<Long>queue=new ArrayDeque<>();
        queue.offer((long) 1);
        queue.offer((long) 1);
        int startingNum=1;
        for (int i = 0; i <n-1 ; i++) {
            long currentNum=queue.poll();
            long  next=queue.poll();
            long sum=currentNum+next;
            queue.offer(sum);
            queue.offer(currentNum);
            
        }
        System.out.println(queue.poll());
        
    }
}
