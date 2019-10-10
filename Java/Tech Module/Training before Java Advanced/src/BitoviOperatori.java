import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

public class BitoviOperatori {
    public static void main(String[] args) throws IOException {
         BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

         int n=Integer.parseInt(reader.readLine());
         int p=Integer.parseInt(reader.readLine());

        n=n>>p;
        System.out.println(n&1);
    }
}
