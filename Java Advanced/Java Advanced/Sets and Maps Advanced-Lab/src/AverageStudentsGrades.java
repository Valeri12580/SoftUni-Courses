import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AverageStudentsGrades {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int numStudents=Integer.parseInt(reader.readLine());

        Map<String, List<Double>>students=new TreeMap<>();
        for (int i = 0; i <numStudents; i++) {
            String []student=reader.readLine().split(" ");
            String name=student[0];
            double grade= Double.parseDouble(student[1]);

            students.putIfAbsent(name,new ArrayList<>());
            students.get(name).add(grade);



        }
        for (Map.Entry<String, List<Double>> stringListEntry : students.entrySet()) {
            double averageGrade=0;

            for (Double grade : stringListEntry.getValue()) {
                averageGrade+=grade;
            }
            averageGrade/=stringListEntry.getValue().size();
            System.out.print(String.format("%s -> ",stringListEntry.getKey()));
            stringListEntry.getValue().forEach(e->{
                System.out.print(String.format("%.2f ",e));;
            });
            System.out.print(String.format("(avg: %.2f)",averageGrade));

            System.out.println();
        }


    }
}
