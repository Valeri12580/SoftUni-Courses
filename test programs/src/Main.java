import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        String text = "Кирил | Иванов | Java\n" +
//                "Милена | Стефанова | PHP\n" +
//                "Благой | Иванов | Java\n" +
//                "Петър | Иванов | Linux\n" +
//                "Стефка | Василева | C++\n" +
//                "Милена | Василева | Java";
//        HashMap<String, ArrayList<Student>> courses = new HashMap<String, ArrayList<Student>>();
//        Scanner input = new Scanner(text);
//        try {
//            while (input.hasNext()) {
//                String line = input.nextLine();
//                String[] studentEntry = line.split("\\s*\\|\\s*");
//                String firstName = studentEntry[0];
//                String lastName = studentEntry[1];
//                String course = studentEntry[2];
//                ArrayList<Student> students = courses.get(course);
//                if (students == null) {
//
//// New course -> create a list of students for it
//                    students = new ArrayList<Student>();
//                    courses.put(course, students);
//                }
//                Student student = new Student(firstName, lastName);
//                students.add(student);
//            }
//        } finally {
//            input.close();
//        }
//// Print the courses and their students
//        Set<String> coursesNames = courses.keySet();
//        for (String course : coursesNames) {
//            System.out.println("Course " + course + ":");
//            ArrayList<Student> students = courses.get(course);
//            Student[] studentsArr = students.toArray(new Student[students.size()]);
//            Arrays.sort(studentsArr);
//            for (Student student : studentsArr) {
//                System.out.printf("\t%s\n", student);
//            }
//        }
//
//
//        Child child=new Child("tapag","kur");
//        System.out.println(child.getNameFirst());

//        Animal cat=new Cat();
//        System.out.println(cat.makeSound());

//        List<Integer>list=new ArrayList<>();
//        addIntegers(list);
//        list.forEach(System.out::println);

        int[] array={1,2,3};
        String[] arrayString={"Ivan","Valeri"};
        System.out.println(arrayString[array[0]]);
        Cat testStudent=new Cat();
     Student student=   testStudent.test();
        System.out.println(student.getName());

    }


//    public static void addIntegers(List<Integer>list){
//        list.add(5);
//        list.add(10);
//    }





}
