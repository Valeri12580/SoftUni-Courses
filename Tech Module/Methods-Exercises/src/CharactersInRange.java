import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        char one=scanner.nextLine().charAt(0);
        char two=scanner.nextLine().charAt(0);


        result(one, two);


    }

    private static void result(char one, char two) {
        int min=0;
        int max=0;
        if (one<two){
            min=one;
            max=two;
        }else{
            min=two;
            max=one;
        }
        for (int i = min+1; i <max; i++) {
            System.out.print((char)i+" ");


        }
    }
}
