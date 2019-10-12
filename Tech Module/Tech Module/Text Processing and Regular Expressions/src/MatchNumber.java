import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String regex="(^|(?<=\\s))-?\\d+(\\.\\d+)?($|(?=\\s))";
        String number=reader.readLine();
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(number);
        List<String>matches=new ArrayList<>();
        while (matcher.find()){
            matches.add(matcher.group());

        }

        System.out.println(String.join(" ",matches));

    }
}
