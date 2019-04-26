import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DigitsLettersAndOthers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String word=reader.readLine();
        StringBuilder alphabetic=new StringBuilder();
        StringBuilder symbols=new StringBuilder();
        StringBuilder nums=new StringBuilder();
        for (int i = 0; i <word.length(); i++) {
            char currentChar=word.charAt(i);
            if(Character.isAlphabetic(currentChar)){
                alphabetic.append(currentChar);
            } else if (Character.isDigit(currentChar)) {
                nums.append(currentChar);

            } else  {
                symbols.append(currentChar);
            }

        }
        System.out.println(nums);
        System.out.println(alphabetic);
        System.out.println(symbols);
    }
}
