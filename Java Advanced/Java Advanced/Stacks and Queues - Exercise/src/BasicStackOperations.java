import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BasicStackOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int [] nSX= Arrays.stream(reader.readLine().split(" ")).mapToInt(e->Integer.parseInt(e)).toArray();
        int pushNumbers=nSX[0];
        int popNumbers=nSX[1];
        int isPresent=nSX[2];
        ArrayDeque<Integer>stack=new ArrayDeque<>();

        Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(e->stack.push(e));

        for (int i = 0; i <popNumbers ; i++) {
            stack.pop();

        }
        if (stack.contains(isPresent)) {

            System.out.println("true");
        }else{
            int smallest=Integer.MAX_VALUE;
            for (int i = 0; i < stack.size(); i++) {
                if(stack.peek()<smallest){
                    smallest=stack.peek();

                }
            }
            if(stack.isEmpty()){
                System.out.println("0");
            }else{
                System.out.println(smallest);
            }

        }

    }
}
