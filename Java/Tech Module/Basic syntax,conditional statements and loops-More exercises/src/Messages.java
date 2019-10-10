import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Messages {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int numberOfPushes=Integer.parseInt(reader.readLine());
        String message="";

        for (int i = 0; i <numberOfPushes; i++) {
            int offset=0;
            String number=reader.readLine();

            int length=number.length();
            char oneDigit=number.charAt(0);

            char mainDigit= (char) Character.getNumericValue(oneDigit);

            if (mainDigit==8 || mainDigit==9){
                 offset=(mainDigit-2)*3+1;
            }else{
                offset=(mainDigit-2)*3;
            }

            int letterIndex=offset+length-1;

            int letterCode=letterIndex+97;
            char letter=(char)letterCode;
            if (mainDigit == 0) {
                letter = (char) (mainDigit + 32);
            }
            message += letter;





        }
        System.out.println(message);
    }
}
