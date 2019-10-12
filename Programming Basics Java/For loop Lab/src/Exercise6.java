import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int left=0;
        int right=0;
        int n=Integer.parseInt(scanner.nextLine());
        for(int counter=0;counter<n;counter++){
            int num=Integer.parseInt(scanner.nextLine());
            if(counter<n){
                left+=num;
            }else{
                right+=num;
            }
        }
        if(left==right){
            System.out.printf("Yes, sum = %d",left);
        }else {
            System.out.printf("No, diff = %d",Math.abs(left-right));
        }


    }
}


