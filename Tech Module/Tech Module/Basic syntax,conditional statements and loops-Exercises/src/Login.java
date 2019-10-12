import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        char reversedChar='.';
        String reversedString="";
        int counter=1;

        for (int i = username.length()-1; i >=0 ; i--) {
            reversedChar=username.charAt(i);
            reversedString+=reversedChar;

            
        }
        String password=scanner.nextLine();
        while(!password.equals(reversedString)){
            if(counter==4){
                System.out.printf("User %s blocked!",username);
                return;
            }
            System.out.println("Incorrect password. Try again.");
            counter++;
            password=scanner.nextLine();

        }
        System.out.println(String.format("User %s logged in.",username));





    }
}
