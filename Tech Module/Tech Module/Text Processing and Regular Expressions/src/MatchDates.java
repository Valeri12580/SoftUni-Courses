import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String regex="\\b(?<day>\\d{2})([\\/ \\. \\-])(?<month>[A-Z]{1}[a-z]{2})\\2(?<year>\\d{4})\\b";
        String input=reader.readLine();

        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(input);
        while (matcher.find()){
            System.out.println(String.format("Day: %s, Month: %s, Year: %s",matcher.group("day")
                    ,matcher.group("month"),matcher.group("year")));
        }




    }
}
