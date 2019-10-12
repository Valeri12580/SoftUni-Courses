import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Integer n=Integer.parseInt(scanner.nextLine());
        DecimalFormat df=new DecimalFormat("#.##");
        double OddSum=0;
        double OddMin=500.0;
        double OddMax=-500.0;
        double EvenSum=0;
        double EvenMin=500.0;
        double EvenMax=-500.0;

        for (int i = 1; i <=n; i++) {
            double num=Double.parseDouble(scanner.nextLine());
            if(i%2==0){
                EvenSum+=num;

                if(EvenMin>num){
                    EvenMin=num;
                }
                if(EvenMax<num){
                    EvenMax=num;
                }

            }else{
                OddSum=OddSum+num;

                if(OddMin>num){
                    OddMin=num;
                }
                if(OddMax<num){
                    OddMax=num;
                }
            }
        }
        System.out.println("OddSum="+df.format(OddSum)+",");

        if(OddMin==0 || OddMin==500){
            System.out.println("OddMin=No"+",");
        }else{
            System.out.println("OddMin="+df.format(OddMin)+",");
        }
        if(OddMax==0 || OddMax==-500){
             System.out.println("OddMax=No"+",");
        }else{
            System.out.println("OddMax="+df.format(OddMax)+",");
        }

        System.out.println("EvenSum="+df.format(EvenSum)+",");

        if(EvenMin==0 || EvenMin==500){
            System.out.println("EvenMin=No"+",");
        }else{
            System.out.println("EvenMin="+df.format(EvenMin)+",");
        }

        if(EvenMax ==0 || EvenMax==-500){
            System.out.println("Evenmax=No");
        }else{
            System.out.println("EvenMax="+df.format(EvenMax));
        }





    }
}
