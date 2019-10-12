import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainStudents {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Students>students=new ArrayList<>();
        String line="";
        while (!"end".equals(line=scanner.nextLine())){
            String[]tokens=line.split("\\s+");

            String firstName=tokens[0];
            String lastName=tokens[1];
            int age=Integer.parseInt(tokens[2]);
            String city=tokens[3];


            Students student=new Students(firstName,lastName,age,city);
            students.add(student);

        }

        String cityName=scanner.nextLine();

        for (Students result:students
             ) {
            if(result.getCity().equals(cityName)){
                System.out.println(String.format("%s %s is %d years old",result.getFirstName(),result.getLastName(),result.getAge()));
            }
        }

    }
}
