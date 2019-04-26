import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long magicNum=Long.parseLong(scanner.nextLine());
        for (int i = 1; i <=9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <9 ; k++) {
                    for (int l = 1; l <=9; l++) {
                        for (int m = 1; m <=9 ; m++) {
                            for (int n = 1; n <=9 ; n++) {
                                long result=i*j*k*l*m*n;
                                if (result==magicNum){
                                    System.out.printf("%d%d%d%d%d%d ", i, j, k, l, m, n);
                                }






                            }

                        }

                    }

                }

            }




            
        }


    }
}
