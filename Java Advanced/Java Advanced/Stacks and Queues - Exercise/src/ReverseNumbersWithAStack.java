import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer>stack=new ArrayDeque<>();


        String []numbers=reader.readLine().split(" ");

        for (int i = 0; i <numbers.length; i++) {
            int num=Integer.parseInt(numbers[i]);
            stack.push(num);
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
