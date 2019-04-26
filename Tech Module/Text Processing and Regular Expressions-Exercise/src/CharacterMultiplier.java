import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharacterMultiplier {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        int space=input.indexOf(" ");

        String one = input.substring(0,space).trim();
        String two = input.substring(space+1).trim();
        getResult(one, two);


    }

    private static void getResult(String one, String two) {
        int min=Math.min(one.length(),two.length());
        int max=Math.max(one.length(),two.length());
        int sum = 0;
        for (int i = 0; i < min; i++) {
            sum += one.charAt(i) * two.charAt(i);


        }
        String maxNameLength=one.length()>two.length()?"one":"two";
        for (int i = min; i <max; i++) {
            if(maxNameLength.equals("one")){
                sum+=one.charAt(i);
            }else{
                sum+=two.charAt(i);
            }

        }
        System.out.println(sum);
    }


}
