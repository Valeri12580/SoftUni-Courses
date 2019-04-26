import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringExplosion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String input=reader.readLine();
        String result="";
        int strength=0;
        for (int i = 0; i <input.length() ; i++) {
            result+=input.charAt(i);

            if(input.charAt(i)=='>'){
                strength +=Integer.parseInt(String.valueOf(input.charAt(i+1)));

                while (strength>0) {

                    strength--;
                    i++;

                    if(i+1==input.length()|| input.charAt(i+1)=='>'){
                        break;
                    }
                }

            }




        }
        System.out.println(result);
    }
}
