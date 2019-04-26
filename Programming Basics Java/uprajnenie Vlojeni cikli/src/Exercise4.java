import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        String tekst=Integer.toString(n);
        int duljina=tekst.length();
        int chislo=0;


        for (int i = 0; i <duljina; i++) {
            chislo=n%10;
            n=n/10;
            if (chislo==0){
                System.out.println("ZERO");
            }else {
                for (int j = 0; j <chislo; j++) {
                    System.out.print((char)(chislo+33));

                }
                System.out.println();


            }



        }





    }

}
