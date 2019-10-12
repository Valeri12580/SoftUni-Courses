import java.util.Scanner;

public class RageExpenses_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice=Double.parseDouble(scanner.nextLine());
        double keyboardPrice=Double.parseDouble(scanner.nextLine());
        double displayPrice=Double.parseDouble(scanner.nextLine());
        double totalPrice=0;

        int counterHeadset=0;
        int counterMouse=0;
        int counterKeyboard=0;
        int counterDisplay=0;
        boolean isTrashedHeadset=false;
        boolean isTrashedMouse=false;
        boolean isTrashedKeyboard=false;


        for (int i = 1; i <=lostGames; i++) {
            if (i%2==0){
                    counterHeadset++;

            }
            if (i%3==0){
                counterMouse++;


            }
            if(i%2==0 && i%3==0){
                counterKeyboard++;
                isTrashedKeyboard=true;


            }
            if (counterKeyboard%2==0 && isTrashedKeyboard){
                counterDisplay++;
                isTrashedKeyboard=false;
            }


        }
        totalPrice=(counterHeadset*headsetPrice)+(counterMouse*mousePrice)+(counterKeyboard*keyboardPrice)+(counterDisplay*displayPrice);
        System.out.println(String.format("Rage expenses: %.2f lv.",totalPrice));

        
        
        
    }
}
