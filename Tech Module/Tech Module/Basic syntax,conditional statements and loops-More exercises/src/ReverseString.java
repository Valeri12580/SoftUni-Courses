import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String reversed = "";
        for (int i = 0; i <name.length(); i++) {
            reversed+=name.charAt(name.length()-1-i);

        }
        System.out.println(reversed);
    }
}