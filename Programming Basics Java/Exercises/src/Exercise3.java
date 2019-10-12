import java.util.Scanner;
public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <n; i++) {
            int n2=Integer.parseInt(scanner.nextLine());

            if (n2<min){
                min=n2;
            }
            if (n2>max){
                max=n2;
            }

        }

        System.out.print("Min="+min+",");
        System.out.print("Max="+max);
    }

}
