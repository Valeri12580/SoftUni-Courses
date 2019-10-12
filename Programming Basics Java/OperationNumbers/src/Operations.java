import java.util.Scanner;
public class Operations {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num1=Integer.parseInt(scanner.nextLine());
        int num2=Integer.parseInt(scanner.nextLine());
        char operator=scanner.nextLine().charAt(0);
        double end=0;
        String evenOdd="";
        switch (operator){
            case '+':
                end=num1+num2;
                evenOdd=end%2==0?"even":"odd";
                System.out.printf("%d %c %d = %.0f - %s",num1,operator,num2,end,evenOdd);
                break;
            case '-':
                end=num1-num2;
                evenOdd=end%2==0?"even":"odd";
                System.out.printf("%d %c %d = %.0f - %s",num1,operator,num2,end,evenOdd);
                break;
            case '*':
                end=num1*num2;
                evenOdd=end%2==0?"even":"odd";
                System.out.printf("%d %c %d = %.0f - %s",num1,operator,num2,end,evenOdd);
                break;
            case '/':
                end=(double)num1/(double)num2;
                switch (num2){
                    case 0:
                        System.out.printf("Cannot divide %d by zero",num1);
                        break;
                    default:
                        System.out.printf("%d / %d = %.2f",num1,num2,end);
                        break;
                }
                break;
            case '%':
                switch (num2){
                    case 0:
                        System.out.printf("Cannot divide %d by zero",num1);
                        break;
                    default:
                        end=num1%num2;
                        System.out.printf("%d %% %d = %.0f\n",num1,num2,end);
                        break;
                }
                break;

        }






    }
}
