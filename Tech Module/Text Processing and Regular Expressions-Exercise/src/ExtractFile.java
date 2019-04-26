import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtractFile {

    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String input=reader.readLine();

        int index=input.lastIndexOf('\\');

        String result=input.substring(index+1);
        String fileName=result.substring(0,result.lastIndexOf('.'));
        String extension=result.substring(result.lastIndexOf('.')+1);
        System.out.println(String.format("File name: %s",fileName));
        System.out.println(String.format("File extension: %s",extension));

    }
}
