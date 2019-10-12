import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivationKeys {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        List<String>finalResult=new ArrayList<>();
        String[]input=reader.readLine().split("&");
        List<String> validInputs= new ArrayList<>();
        Pattern isValid =Pattern.compile("^[A-Za-z0-9]+$");
        for (String currentInput:input) {
            Matcher matcher=isValid.matcher(currentInput);

            if(matcher.find()){
                validInputs.add(matcher.group());
            }

        }

        for (int i = 0; i <validInputs.size(); i++) {
            String current=validInputs.get(i);
            String editedKey="";
            int length=current.length();

            if(length==16){
                for (int j = 0; j <length; j++) {


                    if(j==4 || j==8 ||j==12 ){


                            editedKey+="-";


                    }
                    editedKey+=current.charAt(j);

                }

            }else{
                for (int j = 0; j <length; j++) {


                    if(j==5 || j==10 ||j==15 ||j==20   ){

                            editedKey+="-";


                    }
                    editedKey+=current.charAt(j);

                }


            }
            String keyForResult="";
            for (int j = 0; j <editedKey.length(); j++) {
                char currentChar=editedKey.charAt(j);
                int newNumber=0;
                if(Character.isDigit(currentChar)){
                    newNumber=9-Character.getNumericValue(currentChar);
                    keyForResult+=newNumber;
                }else{
                    keyForResult+=currentChar;
                }

            }
            finalResult.add(keyForResult.toUpperCase());

        }

        System.out.print(String.join(", ",finalResult));
    }
}
