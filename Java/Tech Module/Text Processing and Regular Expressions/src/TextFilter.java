import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String[]bannedWords=reader.readLine().split(", ");
        String text=reader.readLine();



        for (String word:bannedWords
             ) {
            if(text.contains(word)){
                String replacement=multiply("*",word.length());
                text=text.replace(word,replacement);
            }
        }
        System.out.println(text);






    }
    public static String multiply(String text,int count){
        String result="";
        for (int i = 0; i < count; i++) {
            result+=text;
        }
        return result;
    }
}
