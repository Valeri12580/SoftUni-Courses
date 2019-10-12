import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);


        String name=scanner.nextLine();


        if(scanner.hasNextDouble()){
            double yearsInDouble=scanner.nextDouble();
            System.out.println(yearsInDouble);
        }


        System.out.println(name);
    }
}
