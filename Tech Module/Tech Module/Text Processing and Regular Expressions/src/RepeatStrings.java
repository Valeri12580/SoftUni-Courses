import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RepeatStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String[]input=reader.readLine().split("\\s+");
        StringBuilder result=new StringBuilder();

        for (int i = 0; i <input.length; i++) {
            String currentWord=input[i];
            for (int j = 0; j <currentWord.length(); j++) {
                result.append(currentWord);
            }

        }
        System.out.println(result);
    }
}
