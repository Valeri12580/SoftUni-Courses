import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String command=scanner.nextLine();
        while(!command.equals("END")){


            if(command.equalsIgnoreCase("true") || "false".equalsIgnoreCase(command )){
                System.out.println(String.format("%s is boolean type%n",command));
            } else if (isDigit(command)) {
                double toDouble=Double.parseDouble(command);
                if (toDouble%1==0){
                    System.out.printf("%s is integer type%n",command);

                }else{
                    System.out.printf("%s is floating point type%n",command);

                }
            }else if (command.length()==1) {
                System.out.printf("%s is character type%n",command);
            }else if (isString(command)){
                System.out.printf("%s is string type%n",command);
            }
            command=scanner.nextLine();


        }
    }


    public  static  boolean isDigit(String command){
        boolean isDigit=false;

        for (int i = 0; i <command.length(); i++) {
            if (Character.isDigit(command.charAt(i))){
                isDigit=true;
            }


        }
        return  isDigit;

    }



    public static boolean isString(String command){
        boolean isString=false;
        for (int i = 0; i <command.length(); i++) {
            if (Character.isAlphabetic(command.charAt(i))){
                isString=true;
                break;

            }
        }
        return  isString;

    }
}
