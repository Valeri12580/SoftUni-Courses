import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChristmasSpirit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int quantity=Integer.parseInt(reader.readLine());
        int days=Integer.parseInt(reader.readLine());
        int spirit=0;
        int price=0;

        if(days%10==0){
            spirit-=30;
        }

        for (int i = 1; i <=days; i++) {
            if(i%11==0){
                quantity+=2;
            }

            if(i%2==0){
                price+=2*quantity;
                spirit+=5;

                
            }
            if(i%3==0){
                price+=8*quantity;
                spirit+=13;

            }

            if(i%5==0){
                price+=15*quantity;
                spirit+=17;

                if(i%3==0){
                    spirit+=30;
                }
            }

            if(i%10==0){
                price+=23;
                spirit-=20;



            }


        }
        System.out.println(String.format("Total cost: %d",price));
        System.out.println(String.format("Total spirit: %d",spirit));


    }
}
