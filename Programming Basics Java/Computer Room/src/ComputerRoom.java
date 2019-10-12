import java.util.Scanner;
public class ComputerRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int duljina = Integer.parseInt(scanner.nextLine());
        int shirochina = Integer.parseInt(scanner.nextLine());
        int visochina = Integer.parseInt(scanner.nextLine());
        double procent=Double.parseDouble(scanner.nextLine());

        int obemakvarium=duljina*shirochina*visochina;
        double litri=obemakvarium*0.001;
        double procentikoitozaemat=procent*0.01;
        double finale=litri*(1-procentikoitozaemat);







        System.out.printf("%.3f\n",finale);


    }
}
