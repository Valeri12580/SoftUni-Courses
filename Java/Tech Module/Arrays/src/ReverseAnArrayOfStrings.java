import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class ReverseAnArrayOfStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));

        String[] normal=reader.readLine().split(" ");
        String[] reversed=new String[normal.length];

        for (int i = 0; i <normal.length; i++) {
            reversed[i]=normal[normal.length-i-1];
            System.out.print(reversed[i]+" ");

        }
    }
}
