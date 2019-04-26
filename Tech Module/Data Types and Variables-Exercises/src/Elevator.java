import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Elevator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(reader.readLine());
        int p=Integer.parseInt(reader.readLine());

        double result=Math.ceil(n*1.0/p);
        System.out.printf("%.0f",result);


        //drugo reshenie
        System.out.println();

        int another=n%p;

        if (another!=0){
            System.out.println(n/p+1);

        }else{
            System.out.println(n/p);

        }





    }
}
