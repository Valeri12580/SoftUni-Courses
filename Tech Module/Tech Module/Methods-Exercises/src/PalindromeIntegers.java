import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String command=scanner.nextLine();

        while (!"END".equals(command)){
            String reversed="";
            for (int i = command.length()-1; i >=0 ; i--) {
                reversed+=command.charAt(i);

            }
            if (command.equals(reversed)){
                System.out.println("true");
            }else{
                System.out.println("false");
            }
            command=scanner.nextLine();
        }
    }
}
