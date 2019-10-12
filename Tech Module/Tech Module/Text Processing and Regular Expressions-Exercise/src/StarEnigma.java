import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));


        int n=Integer.parseInt(reader.readLine());
        Pattern pattern=Pattern.compile("[star]",Pattern.CASE_INSENSITIVE);
        List<String>attackedPlanets=new ArrayList<>();
        List<String>destroyedPlanets=new ArrayList<>();



        for (int i = 0; i <n; i++) {
            String encryptedMessage=reader.readLine();
            Matcher matcher=pattern.matcher(encryptedMessage);
            int count=0;
            while(matcher.find()){
                count++;

            }
            StringBuilder decryptedMessage= new StringBuilder();
            for (int j = 0; j <encryptedMessage.length(); j++) {
                char currentChar=encryptedMessage.charAt(j);
                decryptedMessage.append(Character.toChars(currentChar-count));


            }
            Pattern patternTwo=Pattern.compile("@(?<planet>[A-Za-z]+)(?:[^@!\\-:>]*):(?<population>\\d+)(?:[^@\\-!:>]*)!(?:[^@\\-!:>]*)(?<mode>A|D)!(?:[^@\\-!:>]*)->(?<soldierCount>\\d+)");
            matcher=patternTwo.matcher(decryptedMessage);

            while (matcher.find()){
                String planetName=matcher.group("planet");
                String attacktype=matcher.group("mode");
                if(attacktype.equals("A")){
                    attackedPlanets.add(planetName);

                }else{
                    destroyedPlanets.add(planetName);
                }
            }




        }
        System.out.println(String.format("Attacked planets: %d",attackedPlanets.size()));
        attackedPlanets.stream().sorted((p1,p2)->p1.compareTo(p2)).forEach(e->{
            System.out.printf("-> %s%n",e);
        });
        System.out.println(String.format("Destroyed planets: %d",destroyedPlanets.size()));
        destroyedPlanets.stream().sorted((p1,p2)->p1.compareTo(p2)).forEach(e->{
            System.out.printf("-> %s%n",e);
        });
    }
}
