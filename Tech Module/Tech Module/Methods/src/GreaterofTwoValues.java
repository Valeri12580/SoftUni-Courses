import java.util.Arrays;
import java.util.Scanner;

public class GreaterofTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();



        switch (command) {
            case "int":
                int num1=Integer.parseInt(scanner.nextLine());
                int num2=Integer.parseInt(scanner.nextLine());
                System.out.println(getMax(num1, num2));
                break;
            case "char":
                char char1=scanner.nextLine().charAt(0);
                char char2=scanner.nextLine().charAt(0);
                System.out.println(getMax(char1, char2));
                break;
            case "String":
                String name1=scanner.nextLine();
                String name2=scanner.nextLine();
                System.out.println(getMax(name1, name2));
                break;
        }


    }

    private static String getMax(String name1, String name2) {
        if (name1.compareTo(name2)<=0){
            return name1;

        }
        return name2;
    }


    static  int getMax(int num1,int num2){

        if (num1>num2){
            return num1;
        }
        return num2;
    }

    static char getMax(char char1,char char2){
        if (char1>char2){
            return char1;
        }
        return char2;
    }


}
