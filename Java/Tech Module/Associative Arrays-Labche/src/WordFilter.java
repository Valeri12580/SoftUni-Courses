import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WordFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String[]input= Arrays.stream(reader.readLine().split("\\s+")).toArray(String[]::new);
        Arrays.stream(input).filter(e->e.length()%2==0).forEach(e-> System.out.println(e));

    }
}
