import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrivingInKathmandu {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String message="";
        String isValid="";


        while(!"Last note".equals(message=reader.readLine())){


            Pattern length=Pattern.compile("(?:=)(\\d+)(?:<<)");
            Matcher matcherForLength=length.matcher(message);
            int duljina=0;
            if(matcherForLength.find()){
                duljina=Integer.parseInt(matcherForLength.group(1));
            }

            Pattern Validation=Pattern.compile("^[A-Za-z0-9!@#$?]+=(\\d+)<<."+"{"+duljina+"}$");
            Matcher MatcherForValidaton=Validation.matcher(message);
            if(!MatcherForValidaton.find()){
                System.out.println("Nothing found!");
                continue;

            }
            Pattern getMountain=Pattern.compile("([^#@?$!]++)(?:\\W)");

            Matcher matcherGetMountain=getMountain.matcher(message);
            String mountain="";

            while (matcherGetMountain.find()){
                mountain+=matcherGetMountain.group(1);
            }

            Pattern getCode=Pattern.compile("(?:[#?!$@])(?:[=\\d]+)<<(.+)");
            Matcher matcherForGetCode=getCode.matcher(message);
            String code="";
            while(matcherForGetCode.find()){
                code+=matcherForGetCode.group(1);
            }


            System.out.println(String.format("Coordinates found! %s -> %s",mountain,code));

        }




    }
}
