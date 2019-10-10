import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        firstLines(n);

    }


    static void firstLines(int n){
        int counter=0;
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print(j+" ");

            }
            System.out.println();
            counter++;

        }
        secondLines(n,counter);
        
    }
    
    static void secondLines(int n,int counter){
        for (int i = n; i >0 ; i--) {
            for (int j = 1; j <counter; j++) {
                System.out.print(j+" ");
            }
            counter--;
            System.out.println();
        }
    }
}
