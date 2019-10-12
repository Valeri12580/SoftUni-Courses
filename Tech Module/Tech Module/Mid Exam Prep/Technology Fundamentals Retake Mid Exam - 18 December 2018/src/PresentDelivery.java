import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class PresentDelivery {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int count=0;
        int[] houses=Arrays.stream(reader.readLine().split("@")).mapToInt(Integer::parseInt).toArray();

        String[] command=reader.readLine().split(" ");
        while(!command[0].equals("Merry")){

            int field=Integer.parseInt(command[1]);
            count+=field;
            while(count>houses.length-1){

                count=count-houses.length;
            }

                if(houses[count]==0){
                    System.out.printf("House %d will have a Merry Christmas.%n",count);
                }else{
                    houses[count]-=2;
                }




            command=reader.readLine().split(" ");

        }
        int countHousesNoChristmas=0;
        boolean isSuccesfull=true;
        for (int i = 0; i <houses.length; i++) {
            if(houses[i]!=0){
                countHousesNoChristmas++;
                isSuccesfull=false;

            }

        }
        System.out.printf("Santa's last position was %d.%n",count);
        if(!isSuccesfull){
            System.out.printf("Santa has failed %d houses.",countHousesNoChristmas);
        }else{
            System.out.println("Mission was successful.");
        }
    }
}
