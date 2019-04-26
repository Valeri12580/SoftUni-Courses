import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Substring {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String word=reader.readLine();
        String fullword=reader.readLine();
        System.out.println(fullword.replace("ice",""));

        while (fullword.contains(word)){
            int index=fullword.indexOf(word);

           fullword=fullword.substring(0,index)+fullword.substring(word.length()+index);
        }
        System.out.println(fullword);
    }
}
