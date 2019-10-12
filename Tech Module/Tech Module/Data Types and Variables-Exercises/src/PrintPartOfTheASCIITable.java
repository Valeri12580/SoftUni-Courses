import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PrintPartOfTheASCIITable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

       int a=Integer.parseInt(reader.readLine());
        int b=Integer.parseInt(reader.readLine());

        for (int i = a; i <=b; i++) {
            System.out.print((char)i+" ");

        }
    }


}
