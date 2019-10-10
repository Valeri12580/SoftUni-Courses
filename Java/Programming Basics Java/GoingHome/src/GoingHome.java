import java.util.Scanner;
public class GoingHome {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int distanciq_kilometri = Integer.parseInt(s.nextLine()); //distanciq v kilometri
        int razhodkola = Integer.parseInt(s.nextLine()); //razhod na kola
        double cenaBenzinlitur = Double.parseDouble(s.nextLine()); //cena na benzin na 1 litur
        int pechalba = Integer.parseInt(s.nextLine()); //specheleni kinti ot turnir
        int razhod_benzin=distanciq_kilometri*razhodkola/100;//razhoda na benzna za 100km
        double plashtane_Benzin=cenaBenzinlitur*razhod_benzin;//cena za gorivoto
        double finale1=(pechalba-plashtane_Benzin);
        double finale2=(double)pechalba/5;
        if (pechalba>=plashtane_Benzin) {
            System.out.printf("You can go home. %.2f money left.", finale1);
        }else{
            System.out.printf("Sorry, you cannot go home. Each will receive %.2f money.",finale2);
        }







    }
}
