import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BalancedParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String> stack = new ArrayDeque<>();

        String[] input = reader.readLine().split("");
        if(input.length%2==1){
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < input.length; i++) {
            String currentInput = input[i];

            if (currentInput.equals("(")) {
                stack.push(currentInput);
            } else if (currentInput.equals("{")) {
                stack.push(currentInput);
            } else if (currentInput.equals("[")) {
                stack.push(currentInput);
            } else if (currentInput.equals(" ")) {
                stack.push(currentInput);
            }
            String peek = stack.peek();

            if (peek.equals("(") && currentInput.equals(")")) {
                stack.pop();
            } else if (peek.equals("{") && currentInput.equals("}")) {
                stack.pop();
            } else if (peek.equals("[") && currentInput.equals("]")) {
                stack.pop();
            } else if (peek.equals(" ") && currentInput.equals(" ")) {
                stack.pop();
            }


        }
        if (stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
