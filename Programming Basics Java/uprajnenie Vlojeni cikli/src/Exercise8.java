import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        String presentation=scanner.nextLine();
        double average=0;
        double averageAll=0;
        int counter=0;
        while(!presentation.equals("Finish")){
            for (int i = 0; i <n; i++) {
                double ocenka=Double.parseDouble(scanner.nextLine());
                average+=ocenka/n;
            }
            counter++;
            averageAll+=average;
            System.out.printf("%s - %.2f.%n",presentation,average);
            average=0;
            presentation=scanner.nextLine();


        }
        averageAll/=counter;

        System.out.printf("Student's final assessment is %.2f.",averageAll);
    }
}
