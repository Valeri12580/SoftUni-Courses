import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReplaceRepeatingChars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));


        String result=reader.readLine();

        for (int i = 0; i <result.length(); i++) {
            char currentChar=result.charAt(i);
            int indexOfChar=result.indexOf(currentChar,i);
            int counter=0;
            for (int j = indexOfChar; j <result.length(); j++) {
                if(result.charAt(j)==currentChar){
                    counter++;
                }else {
                    if(counter!=0){
                        result=result.replace(multiplier(currentChar,counter),String.valueOf(currentChar));
                        break;
                    }
                }
            }

                result=result.replace(multiplier(currentChar,counter),String.valueOf(currentChar));

            //TODO opravi posledniq sluchai

            counter=0;



        }
        System.out.println(result);
    }

    public static StringBuilder multiplier(char c,int counter){
        StringBuilder result=new StringBuilder("");
        for (int i = 0; i <counter; i++) {
            result.append(c);
        }
        return result;

    }
}
