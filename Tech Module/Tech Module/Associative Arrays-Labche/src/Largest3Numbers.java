import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        List<String>input= Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());

        input.stream().map(e->Integer.parseInt(e)).sorted((p1,p2)->Integer.compare(p2,p1)).limit(3).forEach(e-> System.out.print(e+" "));



    }
}
