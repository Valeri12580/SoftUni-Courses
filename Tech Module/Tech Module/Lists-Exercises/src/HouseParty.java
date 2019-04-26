import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numbersCommands=Integer.parseInt(scanner.nextLine());
        List<String >list=new ArrayList<>();

        for (int i = 0; i <numbersCommands ; i++) {
            String[] command=scanner.nextLine().split(" ");

            switch (command[2]){
                case "going!":
                    if(!list.contains(command[0])){
                        list.add(command[0]);
                    }else{
                        System.out.println(String.format("%s is already in the list!",command[0]));
                    }
                    break;
                case "not":
                    if(list.contains(command[0])){
                        list.remove(command[0]);
                    }else{
                        System.out.println(String.format("%s is not in the list!",command[0]));
                    }
                    break;

            }

        }
        for (String name:list
             ) {
            System.out.println(name
            );
        }
    }

}
