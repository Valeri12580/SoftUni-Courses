import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ConcatNames {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String name1=bf.readLine();
        String name2=bf.readLine();
        String name3=bf.readLine();

        System.out.println(name1+name3+name2);
    }
}
