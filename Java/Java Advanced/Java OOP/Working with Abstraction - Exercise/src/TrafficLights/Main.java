package TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));


        String[]inputLights=reader.readLine().split(" ");
        int n=Integer.parseInt(reader.readLine());



        for (int i = 0; i < n; i++) {

            for (int j = 0; j < inputLights.length; j++) {
                int getValue=TrafficLights.valueOf(inputLights[j]).getValue();
                if(getValue==2){
                    inputLights[j]="RED";
                }else if (getValue==0){
                    inputLights[j]="GREEN";
                }else{
                    inputLights[j]="YELLOW";
                }
                System.out.print(inputLights[j]+" ");
            }
            System.out.println();

        }

    }
}
