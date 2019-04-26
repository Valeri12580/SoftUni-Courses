import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        double p2=0;
        double p3=0;
        double p4=0;
        int counterP1=0;
        int counterP2=0;
        int counterP3=0;
        int counterP4=0;
        for (int i = 0; i <n; i++) {
            int num=Integer.parseInt(scanner.nextLine());
            if (num%2==0){
                counterP2++;
            }
            if (num%3==0){
                counterP3++;
            }
            if (num%4==0){
                counterP4++;
            }
            
        }
        p2=(double)counterP2/n*100;
        p3=(double)counterP3/n*100;
        p4=(double)counterP4/n*100;
        System.out.printf("%.2f%%\n",p2);
        System.out.printf("%.2f%%\n",p3);
        System.out.printf("%.2f%%\n",p4);
    }
}
