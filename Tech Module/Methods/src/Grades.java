import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        result(Double.parseDouble(scanner.nextLine()));

    }

    static  void result(double grade){
        if (grade<=2.99){
            System.out.print("Fail");
        }else if (grade<=3.49){
            System.out.print("Poor");
        }else if (grade<=4.49){
            System.out.print("Good");
        }else if (grade<=5.49){
            System.out.print("Very good");
        }else{
            System.out.print("Excellent");
        }
    }
}
