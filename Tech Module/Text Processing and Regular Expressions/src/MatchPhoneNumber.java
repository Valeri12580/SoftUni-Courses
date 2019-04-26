import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String regex="\\+359([- ])2\\1[\\d]{3}\\1[\\d]{4}\\b";

        String input=reader.readLine();
        List<String>result=new ArrayList<>();


        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(input);

        while (matcher.find()){
            result.add(matcher.group());

        }
        System.out.println(String.join(", ",result));

    }
}
