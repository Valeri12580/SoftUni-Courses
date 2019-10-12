import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int counter1=0;
        int counter2=0;
        int counter3=0;
        int counter4=0;
        int counter5=0;

        for (int i = 0; i <n; i++) {
            Integer number=Integer.parseInt(scanner.nextLine());
            if (number<200){
                counter1++;
            }else if(number<=399){
                counter2++;
            }else if (number<=599){
                counter3++;
            }else if (number<=799){
                counter4++;
            }else if (number>=800){
                counter5++;
            }

        }
        double p1=(double)counter1/n*100;
        double p2=(double)counter2/n*100;
        double p3=(double)counter3/n*100;
        double p4=(double)counter4/n*100;
        double p5=(double)counter5/n*100;
        System.out.printf("%.2f%n",p1);
        System.out.printf("%.2f%n",p2);
        System.out.printf("%.2f%n",p3);
        System.out.printf("%.2f%n",p4);
        System.out.printf("%.2f%n",p5);

    }
}
