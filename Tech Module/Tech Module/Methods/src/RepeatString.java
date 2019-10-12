import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String name=scanner.nextLine();
        int n =Integer.parseInt(scanner.nextLine());


        System.out.println(result(name, n));
    }

    private static String result(String name, int n) {
        String result="";
        for (int i = 0; i <n; i++) {
            result+=name;

        }
        return result;
    }
}
