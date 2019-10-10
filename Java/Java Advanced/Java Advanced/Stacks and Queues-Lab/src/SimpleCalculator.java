import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class SimpleCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<String>stack=new ArrayDeque<>();
        int sum=0;
        String opearor="+";
        String[] input=reader.readLine().split(" ");
        Collections.addAll(stack,input);
        while (!stack.isEmpty()) {
            String current=stack.pop();
            int num=0;



            switch (current){
                case "+":
                    opearor="+";

                    break;

                case "-":
                    opearor="-";
                    break;

                default:
                    num=Integer.parseInt(current);
                    break;


            }
            switch (opearor){
                case "+":
                    sum+=num;

                    break;

                case "-":
                    sum-=num;
                    break;

                default:
                    sum+=num;
                    break;


            }

        }
        System.out.println(sum);
    }
}
