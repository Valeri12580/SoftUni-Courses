import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer>numbers= Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).
                collect(Collectors.toList());

        String command=scanner.nextLine();
        while(!command.equals("end")){
            String[]tokens=command.split("\\s+");
            int num=0;
            switch (tokens[0]){

                case "Add":
                     num=Integer.parseInt(tokens[1]);
                    numbers.add(num);
                    break;
                case "Remove":
                    num=Integer.parseInt(tokens[1]);
                    numbers.remove((Object)num);
                    break;

                case "RemoveAt":
                    num=Integer.parseInt(tokens[1]);
                    numbers.remove(num);
                    break;

                case "Insert":
                    num=Integer.parseInt(tokens[1]);
                    int index=Integer.parseInt(tokens[2]);
                    numbers.add(index,num);
                    break;

            }

            command=scanner.nextLine();
        }
        for (int num:numbers
             ) {
            System.out.print(num+" ");
        }


    }

}
