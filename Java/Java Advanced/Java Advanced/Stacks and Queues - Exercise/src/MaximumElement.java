import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(reader.readLine());
        ArrayDeque<Integer>stack=new ArrayDeque<>();

        for (int i = 0; i <n ; i++) {
        String[]input=reader.readLine().split(" ");
        String command=input[0];
        switch (command){
            case "1":
                int element = Integer.parseInt(input[1]);
                stack.push(element);
                break;

            case "2":
                stack.pop();

                break;

            case "3":
                System.out.println(Collections.max(stack));

                break;
        }

        }
    }
}
