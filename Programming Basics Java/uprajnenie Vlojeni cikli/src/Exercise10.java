import java.util.Scanner;

public class Exercise10 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int l = Integer.parseInt(scan.nextLine());
        boolean isTrue=false;

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=n; j++) {
                for (int k = 'a';  k<'a'+l; k++) {
                    for (int m = 'a'; m <'a'+l; m++) {
                        for (int o =Math.max(i,j)+1; o <=n; o++) {
                            if (o>n){
                                return;
                            }
                            System.out.printf("%d%d%c%c%d ", i, j, k, m, o);



                        }


                    }

                }

            }


        }
    }
}




