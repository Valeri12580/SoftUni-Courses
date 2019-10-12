import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int even=0;
        int odd=0;

        for(int counter=0;counter<n;counter++) {
            int num = Integer.parseInt(scanner.nextLine());

            if (counter % 2 == 0) {
                even += num;
            } else {
                odd += num;
            }

        }
        if (even-odd==0){
            System.out.println("Yes sum= "+even);
        }else{
            System.out.println("No Diff = "+Math.abs(even-odd));
        }


    }
}
