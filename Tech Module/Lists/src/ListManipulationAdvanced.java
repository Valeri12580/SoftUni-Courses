import java.util.*;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).
                collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] tokens = command.split("\\s+");
            int num = 0;
            switch (tokens[0]) {

                case "Add":
                    num = Integer.parseInt(tokens[1]);
                    numbers.add(num);
                    break;
                case "Remove":
                    num = Integer.parseInt(tokens[1]);
                    numbers.remove((Object) num);
                    break;

                case "RemoveAt":
                    num = Integer.parseInt(tokens[1]);
                    numbers.remove(num);
                    break;

                case "Insert":
                    num = Integer.parseInt(tokens[1]);
                    int index = Integer.parseInt(tokens[2]);
                    numbers.add(index, num);
                    break;
                case "Contains":
                    num = Integer.parseInt(tokens[1]);
                    System.out.println(numbers.contains(num) ? "Yes" : "No such number");
                    break;
                case "Filter":
                    switch (tokens[1]) {
                        case "<": {
                            List<Integer> result = numbers.stream().filter(value -> value < Integer.parseInt(tokens[2])).collect(Collectors.toList());
                            print(result);

                            break;
                        }
                        case ">": {
                            List<Integer> result = numbers.stream().filter(value -> value > Integer.parseInt(tokens[2])).collect(Collectors.toList());
                            print(result);

                            break;
                        }
                        case "<=": {
                            List<Integer> result = numbers.stream().filter(value -> value <= Integer.parseInt(tokens[2])).collect(Collectors.toList());
                            print(result);
                            break;
                        }
                        case ">=": {
                            List<Integer> result = numbers.stream().filter(value -> value >= Integer.parseInt(tokens[2])).collect(Collectors.toList());
                            print(result);
                            break;
                        }
                    }
                    break;
                default:
                    String resultString="";
                    if (command.equals("Print even")) {

                        for (int getEven : numbers) {
                            if (getEven % 2 == 0) {
                                resultString+=getEven+" ";
                            }

                        }
                        System.out.println(resultString.trim());
                    } else if (command.equals("Print odd")) {
                        for (int getOdd : numbers) {
                            if (getOdd % 2 == 1) {
                                resultString+=getOdd+" ";
                            }
                        }
                        System.out.println(resultString.trim());
                    } else if (command.equals("Get sum")) {
                        int sum = 0;
                        for (int i : numbers) {
                            sum += i;
                        }
                        System.out.println(sum);
                    }
                    break;
            }
            command = scanner.nextLine();

        }

    }

    static void print(List<Integer> result) {
        String resultString="";
        for (int sorted : result) {
           resultString+=sorted+" ";
        }
        System.out.println(resultString.trim());
    }
}
