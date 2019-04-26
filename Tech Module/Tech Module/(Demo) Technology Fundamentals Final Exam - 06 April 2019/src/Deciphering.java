import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphering {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String text=reader.readLine();
        String[] substrings=reader.readLine().split(" ");
        String result="";
        Pattern pattern=Pattern.compile("^[d-z{ },|#]+$");
        Matcher matcher=pattern.matcher(text);
        if(matcher.find()){
            for (int i = 0; i <text.length(); i++) {
                char currentCharDecrtypted=(char)(text.charAt(i)-3);
                result+=currentCharDecrtypted;

            }
            result=result.replace(substrings[0],substrings[1]);
            System.out.println(result);
        }else{
            System.out.println( "This is not the book you are looking for.");
        }












    }
}
