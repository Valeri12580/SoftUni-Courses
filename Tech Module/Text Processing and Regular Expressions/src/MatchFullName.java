import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String regex="\\b[A-Z][a-z]+ [A-Z][a-z]+\\b";
        String input=reader.readLine();


        Pattern pattern=Pattern.compile(regex);

            Matcher matcher=pattern.matcher(input);

            while (matcher.find()){
                System.out.print(matcher.group()+" ");

        }




    }
}
