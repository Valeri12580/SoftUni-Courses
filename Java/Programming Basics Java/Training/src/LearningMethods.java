import java.util.Scanner;

public class LearningMethods {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int z=Integer.parseInt(scanner.nextLine());
        kakvoeChisloto(z);
        int width=Integer.parseInt(scanner.nextLine());
        int height=Integer.parseInt(scanner.nextLine());
        int results=getRectagnleArea(width,height);
        System.out.println(results);
        String dada=scanner.nextLine();
        printLogo(dada);

    }

   private static void kakvoeChisloto(int number){
        if (number>=0){
            System.out.println("Положително");
        }else{
            System.out.println("Отрицателно");
        }




    }
    private static int getRectagnleArea(double width, double height){
        double area = width * height;
        return (int)area;
    }

    public static void printLogo(String imeNaFirma) {
        System.out.printf("Firmata e:%s",imeNaFirma);
    }




}
