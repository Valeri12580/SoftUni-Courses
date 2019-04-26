import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidUsernames {
    public static void main(String[] args) throws IOException {

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String[]input=reader.readLine().split(", ");

        for (String word:input) {
            if (Validate(word)) {
                System.out.println(word);
            }

        }


    }

    public  static boolean Validate(String word) {

        if (word.length() < 3 || word.length() > 16) {
            return false;
        }

        for (int i = 0; i <word.length() ; i++) {
            if(!Character.isLetterOrDigit(word.charAt(i))&&word.charAt(i)!='-'&&word.charAt(i)!='_'){
                return false;

            }
        }
        return true;


    }

}
