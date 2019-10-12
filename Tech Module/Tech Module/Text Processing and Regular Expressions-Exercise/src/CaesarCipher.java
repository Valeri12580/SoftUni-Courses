import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CaesarCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String input=reader.readLine();
        StringBuilder result=new StringBuilder();

        for (int i = 0; i <input.length(); i++) {
            char currentChar=input.charAt(i);

            result.append(Character.toChars(currentChar+3));

        }
        System.out.println(result);

    }
}
