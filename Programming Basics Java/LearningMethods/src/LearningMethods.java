import java.util.Scanner;

public class LearningMethods {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        helloSuobshtenie();
        int z=Integer.parseInt(scanner.nextLine());
        kakvoeChisloto(z);
        int width=Integer.parseInt(scanner.nextLine());
        int height=Integer.parseInt(scanner.nextLine());
        int results=getRectagnleArea(width,height);
        System.out.println(results);
        String dada=scanner.nextLine();
        printLogo(dada);
        izrazKatoArgument(3+5);
        printNameAndAge("Valeri",18);
        System.out.println(promenlivBroiArgumenti(5,2,3,6));

    }

    private static void kakvoeChisloto(int number){

        if (number>=0){
            System.out.println("Положително");
        }else{
            System.out.println("Отрицателно");
        }





    }

    public  static   void helloSuobshtenie(){
        System.out.println("Zdr");
    }
    private static int getRectagnleArea(double debelina, double visochina){
        double area = debelina * visochina;
        return (int)area;
    }

    public static void printLogo(String imeNaFirma) {

        System.out.printf("Firmata e:%s%n",imeNaFirma);
    }
    public  static void izrazKatoArgument(int sbor){
        int presmetnatoChisloOtArgument=sbor;
        System.out.println(sbor);
        System.out.println(presmetnatoChisloOtArgument);
    }

    public static void printNameAndAge(String name,int age){
        System.out.printf("The name is %s,the age is %d%n",name,age);
    }

    public  static int promenlivBroiArgumenti(int ...chislo){
        int sum=0;
        for (int pribavqne:chislo) {
            sum+=pribavqne;

        }
        return sum;


    }






}
