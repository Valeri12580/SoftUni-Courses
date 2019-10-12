import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String command=scanner.nextLine();
        int n1=Integer.parseInt(scanner.nextLine());
        int n2=Integer.parseInt(scanner.nextLine());

        switch (command){
            case "add":
                add(n1,n2);
                break;
            case "multiply":
                multiply(n1,n2);
                break;
            case "subtract":
                subtract(n1,n2);
                break;
            case "divide":
                divide(n1,n2);
                break;
        }
    }

    static void add(int num1,int num2){
        int result=num1+num2;
        System.out.println(result);
    }
    static void multiply(int num1,int num2){
        int result=num1*num2;
        System.out.println(result);
    }
    static void subtract(int num1,int num2){
        int result=num1-num2;
        System.out.println(result);
    }
    static void divide(int num1,int num2){
        int result=num1/num2;
        System.out.println(result);
    }

}
