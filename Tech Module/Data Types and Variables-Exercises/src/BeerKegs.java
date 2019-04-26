import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeerKegs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(reader.readLine());
        double max=Double.MIN_VALUE;
        String winnerModel="";

        for (int i = 0; i <n; i++) {

            String model=reader.readLine();
            double radius=Double.parseDouble(reader.readLine());
            int height=Integer.parseInt(reader.readLine());
            double volume=Math.PI*Math.pow(radius,2)*height;

            if(volume>max){
                max=volume;
                winnerModel=model;
            }


        }
        System.out.println(winnerModel);
    }
}
