import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheIsleOfManTTRace {
    public static void main(String[] args) throws IOException {

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern=Pattern.compile("^([#$%*&])(?<name>[A-Za-z]+)\\1=(?<length>\\d+)!!(?<code>.+$)");
        String finalResult="";
        boolean foundedMatch=false;

        while (foundedMatch==false){
            String input=reader.readLine();
            Matcher matcher=pattern.matcher(input);
            if(matcher.find()){
                int length= Integer.parseInt(matcher.group("length"));
                String theCode=matcher.group("code");
                if(theCode.length()==length){
                    foundedMatch=true;
                    String newCode="";
                    for (int i = 0; i <length; i++) {
                        newCode+=String.valueOf(Character.toChars(theCode.charAt(i)+length));
                    }
                    System.out.println(String.format("Coordinates found! %s -> %s",matcher.group("name"),newCode));
                    break;
                }
            }
            System.out.println("Nothing found!");
        }
    }
}
