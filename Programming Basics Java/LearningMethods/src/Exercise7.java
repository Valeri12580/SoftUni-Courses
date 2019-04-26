import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int number=Integer.parseInt(scanner.nextLine());
        solutionOne(number);
        System.out.println();
        solutionTwo(number);

    }

    private static void solutionOne(int number){
        String toString=number+"";
        for (int i = 0; i <toString.length(); i++) {
            int lastNumber=number%10;
            number/=10;
            System.out.print(lastNumber);

        }

    }
    private static void solutionTwo(int number){
        String toString=number+"";
        for (int i = toString.length()-1; i>=0; i--) {
            char result=toString.charAt(i);
            System.out.print(result);


        }
    }


}
