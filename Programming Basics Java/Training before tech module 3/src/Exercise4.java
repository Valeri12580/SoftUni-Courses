import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String teamName=scanner.nextLine();
        int playedMatches=Integer.parseInt(scanner.nextLine());
        int numPoints=0;
        int goalDiff=0;
        int goalInCounter=0;
        int goalReceivedConter=0;


        for (int i = 0; i <playedMatches; i++) {
            int vkaraniGolove = Integer.parseInt(scanner.nextLine());
            int polucheniGolove = Integer.parseInt(scanner.nextLine());
            if (vkaraniGolove > polucheniGolove) {
                numPoints += 3;

            } else if (vkaraniGolove==polucheniGolove){
                numPoints+=1;

            }
            goalInCounter+=vkaraniGolove;
            goalReceivedConter+=polucheniGolove;





        }
        int razlika=goalInCounter-goalReceivedConter;


        if (goalInCounter>=goalReceivedConter) {
            System.out.printf("%s has finished the group phase with %d points.%n",teamName,numPoints);
            System.out.printf("Goal difference: %d.",razlika);
        }else{
            System.out.printf("%s has been eliminated from the group phase.%n",teamName);
            System.out.printf("Goal difference: %d.",razlika);
        }
    }
}
