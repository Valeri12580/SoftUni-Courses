import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> courses = new LinkedHashMap<>();
        String line = scanner.nextLine();

        while (!"end".equalsIgnoreCase(line)) {
            String[] arrLine = line.split(" : ");
            String courseName = arrLine[0];
            String studentName = arrLine[1];

            courses.putIfAbsent(courseName, new ArrayList<>());
            List<String> students = courses.get(courseName);
            students.add(studentName);
            Collections.sort(students);

            line = scanner.nextLine();
        }

        courses
                .entrySet()
                .stream()
                .sorted((x, y) -> Integer.compare(y.getValue().size(), x.getValue().size()))
                .forEach(entry -> {
                    System.out.println(String.format("%s: %d", entry.getKey(), entry.getValue().size()));
                    entry.getValue().forEach(e -> System.out.println("-- " + e));
                });
    }
}