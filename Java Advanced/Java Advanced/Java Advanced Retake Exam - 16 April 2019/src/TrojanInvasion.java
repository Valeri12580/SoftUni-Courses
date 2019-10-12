import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class TrojanInvasion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int wavesOFTrojanWarriors = Integer.parseInt(reader.readLine());
        int[] inputSpartanDefenses = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> spartanDefenses = new ArrayDeque<>();


        for (int i = 0; i < inputSpartanDefenses.length; i++) {
            spartanDefenses.offer(inputSpartanDefenses[i]);

        }
        ArrayDeque<Integer>attackers=new ArrayDeque<>();


        for (int i = 1; i <= wavesOFTrojanWarriors && !spartanDefenses.isEmpty(); i++) {



            Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(attackers::push);
            if (i % 3 == 0) {
                int n = Integer.parseInt(reader.readLine());
                spartanDefenses.offer(n);
            }
            while (!spartanDefenses.isEmpty() && !attackers.isEmpty()){
                int attacker=attackers.pop();
                int defender=spartanDefenses.poll();

                if(attacker>defender){
                    attacker-=defender;
                    attackers.push(attacker);
                }else if (defender>attacker){
                    defender-=attacker;
                    spartanDefenses.addFirst(defender);
                }
            }



        }
        if(spartanDefenses.isEmpty()){
            System.out.println("The Trojans successfully destroyed the Spartan defense.");
            System.out.printf("Warriors left: %s%n",String.join(", ",attackers.toString().replaceAll("\\[|\\]","")));



        }else{

            System.out.println("The Spartans successfully repulsed the Trojan attack.");
            System.out.print("Plates left: ");
            while(!spartanDefenses.isEmpty()){
                if (spartanDefenses.size() == 1) {
                    System.out.print(spartanDefenses.poll());
                    break;
                }
                System.out.print(spartanDefenses.poll() + ", ");

            }
        }





        //



    }



}












