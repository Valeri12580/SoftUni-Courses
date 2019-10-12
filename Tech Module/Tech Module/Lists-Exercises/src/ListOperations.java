import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("End")) {

            String[] data = input.split("\\s+");
            String command = data[0];

            switch (command) {
                case "Add":
                    elements.add(data[1]);
                    break;
                case "Insert":
                    String element = data[1];
                    int index = Integer.parseInt(data[2]);

                    if (index >= 0 && index < elements.size()) {
                        elements.add(index, data[1]);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int indToRemove = Integer.parseInt(data[1]);

                    if (indToRemove >= 0 && indToRemove < elements.size()) {
                        elements.remove(indToRemove);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    int count = Integer.parseInt(data[2]);

                    if (elements.size() > 0) {
                        if (data[1].equals("left")) {

                            for (int i = 0; i < count % elements.size(); i++) {
                                elements.add(elements.get(0));
                                elements.remove(0);
                            }
                        } else {

                            for (int i = 0; i < count % elements.size(); i++) {
                                elements.add(0, elements.get(elements.size() - 1));
                                elements.remove(elements.size() - 1);
                            }
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}