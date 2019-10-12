import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int counter=0;



        char lastSector=scanner.nextLine().charAt(0);
        int numRowsFirstSector=Integer.parseInt(scanner.nextLine());
        int numPlaces = Integer.parseInt(scanner.nextLine());

        for(char firstSector='A';firstSector<=lastSector;firstSector++){


            for (int i = 1; i <=numRowsFirstSector; i++) {
                if (i%2==0){
                    for (char j = 'a'; j <'a'+numPlaces+2; j++) {
                        System.out.printf("%c%d%c%n",firstSector,i,j);
                        counter++;

                    }
                }else {
                    for (char j = 'a'; j <'a'+numPlaces; j++) {
                        System.out.printf("%c%d%c%n",firstSector,i,j);
                        counter++;
                    }
                }
                
            }
            numRowsFirstSector++;


        }
        System.out.println(counter);



    }
}
