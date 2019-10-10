package Students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(reader.readLine());

        List<Students>data=new ArrayList<>();

        for (int i = 0; i <n; i++) {
            String[]input=reader.readLine().split("\\s+");
            Students students=new Students(input[0],input[1],Double.parseDouble(input[2]));

            data.add(students);
            
        }


        data.stream().sorted((p1,p2)->Double.compare(p2.getGrade(),p1.getGrade())).forEach(e-> System.out.println(e.toString()));




    }
}
