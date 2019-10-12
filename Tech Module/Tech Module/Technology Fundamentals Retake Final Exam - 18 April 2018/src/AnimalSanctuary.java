import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnimalSanctuary {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(reader.readLine());
        Pattern isValid=Pattern.compile("n:(?<name>[^;]+);t:(?<type>[^;]+);c--(?<country>[a-zA-Z0-9_ ]+)");
        int kg=0;
        for (int i = 0; i <n; i++) {

            String input=reader.readLine();
            Matcher isValidMatcher=isValid.matcher(input);
            if (isValidMatcher.find()) {
                String name=isValidMatcher.group("name").replaceAll("[^A-Za-z]","");
                String type=isValidMatcher.group("type").replaceAll("[^A-Za-z]","");
                String country=isValidMatcher.group("country").replaceAll("[^A-Za-z ]","");


                for (int j = 0; j <input.length(); j++) {
                    char currentChar=input.charAt(j);

                    if(Character.isDigit(currentChar)){
                        kg+=Character.getNumericValue(currentChar);
                    }

                }
                System.out.println(String.format("%s is a %s from %s",name,type,country.trim()));


            }


        }
        System.out.println(String.format("Total weight of animals: %dKG",kg));
    }
}
