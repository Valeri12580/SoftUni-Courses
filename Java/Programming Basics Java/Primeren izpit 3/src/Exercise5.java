import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String teamName=scanner.nextLine();
        int playedMatches=Integer.parseInt(scanner.nextLine());
        int sumMinutes=0;
        double averageMinutes=0;
        int penalties=0;
        int additionalTime=0;
        for (int i = 0; i <playedMatches; i++) {
            int produljitelnost=Integer.parseInt(scanner.nextLine());
            sumMinutes+=produljitelnost;
            if (produljitelnost>90 && produljitelnost<=120){
                additionalTime+=1;

            }else if (produljitelnost>120){
                penalties+=1;
            }

        }
        averageMinutes=(double)sumMinutes/playedMatches;

        System.out.printf("%s has played %d minutes. ",teamName,sumMinutes);
        System.out.printf("Average minutes per game: %.2f%n",averageMinutes);
        System.out.println("Games with penalties: "+penalties);
        System.out.printf("Games with additional time: %d",additionalTime);





    }
}
