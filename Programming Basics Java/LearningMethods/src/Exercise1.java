import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();
        getName(name);

    }

    public static  void getName(String name){
        System.out.printf("Hello,%s!",name);
    }
}
