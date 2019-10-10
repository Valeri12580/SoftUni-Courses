import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String teamName=scanner.nextLine();
        int playedMatches=Integer.parseInt(scanner.nextLine());
        int durationAllMatches=0;
        double averageTime=0;
        int numMatchesPenalties=0;
        int numMatchesAdditionalTime=0;


        for (int i = 0; i <playedMatches; i++) {
            int duration=Integer.parseInt(scanner.nextLine());
            durationAllMatches+=duration;
            if (duration>90 && duration<=120){
                numMatchesAdditionalTime++;

            }else if (duration>120) {
                numMatchesPenalties++;

            }

        }

        averageTime=(double)durationAllMatches/playedMatches;

        printResults(teamName,durationAllMatches,averageTime,numMatchesPenalties,numMatchesAdditionalTime);


    }

    public  static void printResults(String teamName,int durationAllMatches,double averageTime,int numMatchesPenalties,int numMatchesAdditionalTime){
        System.out.printf("%s has played %d minutes. Average minutes per game: %.2f\n",teamName,durationAllMatches,averageTime);
        System.out.printf("Games with penalties: %d%n",numMatchesPenalties);
        System.out.printf("Games with additional time: %d",numMatchesAdditionalTime);
    }
}
