import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Integer>wagons= Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity=Integer.parseInt(scanner.nextLine());

        String[]command=scanner.nextLine().split(" ");

        while (!command[0].equals("end")){
            if (command[0].equals("Add")){
                wagons.add(Integer.parseInt(command[1]));
            }else{
                int n= Integer.parseInt(command[0]);
                for (int i = 0; i <wagons.size(); i++) {
                    if(wagons.get(i)+n<=maxCapacity){
                        wagons.set(i,wagons.get(i)+n);
                        break;
                    }
                }
            }
            command=scanner.nextLine().split(" ");
        }

        System.out.println(wagons.toString().replaceAll("[\\[\\],]",""));
    }
}
