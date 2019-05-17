import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class MatchingBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer>stack=new ArrayDeque<>();
        String input=reader.readLine();
        List<String> finale=new ArrayList<>();
        for (int i = 0; i <input.length() ; i++) {
            char currentChar=input.charAt(i);


            switch (currentChar){
                case '(':
                    stack.push(i);
                    break;

                case ')':
                    int startIndex=stack.pop();
                    System.out.println(input.substring(startIndex,i+1));
                    break;
            }


        }
    }
}
