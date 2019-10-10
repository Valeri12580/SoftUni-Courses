import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String teamName=scanner.nextLine();
        int playedMatches=Integer.parseInt(scanner.nextLine());
        int sum=0;
        int vkarani=0;
        int polucheni=0;
        for (int i = 0; i <playedMatches; i++) {
            int vkaraniGolove=Integer.parseInt(scanner.nextLine());
            int polucheniGolove=Integer.parseInt(scanner.nextLine());
            vkarani+=vkaraniGolove;
            polucheni+=polucheniGolove;
            if (vkaraniGolove>polucheniGolove){
                sum+=3;

            }else if (vkaraniGolove==polucheniGolove){
                sum+=1;
            }

        }

        if (vkarani>=polucheni){
            System.out.printf("%s has finished the group phase with %d points.%n",teamName,sum);
            System.out.printf("Goal difference: %d.",vkarani-polucheni);

        }else{
            System.out.printf("%s has been eliminated from the group phase.%n",teamName);
            System.out.printf("Goal difference: %d.",vkarani-polucheni);
        }



    }
}
