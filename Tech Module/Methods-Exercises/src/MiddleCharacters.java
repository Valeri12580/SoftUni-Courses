import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();
        getMiddleChar(name);



    }


    static void getMiddleChar(String name){
        String result="";
        if (name.length()%2==0){
            result=String.valueOf(name.charAt(name.length()/2-1))+String.valueOf(name.charAt(name.length()/2));
        }else{
            result=String.valueOf(name.charAt(name.length()/2));
        }
        System.out.println(result);
    }
}
