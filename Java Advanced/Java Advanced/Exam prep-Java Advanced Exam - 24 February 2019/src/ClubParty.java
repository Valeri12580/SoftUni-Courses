import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ClubParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int n =Integer.parseInt(reader.readLine());
        String[] input=reader.readLine().split(" ");

        Deque<String>hallsAndReservation=initializeDeque(input,n);


        Deque<String>halls=new ArrayDeque<>();
        Deque<Integer>currentHallReservation=new ArrayDeque<>();

        int currentHallCapacity=0;


       while (!hallsAndReservation.isEmpty()) {
            String current=hallsAndReservation.pop();

           if(Character.isDigit(current.charAt(0))){

                int reservation=Integer.parseInt(current);
                if(currentHallCapacity+reservation>n){
                    printHall(halls,currentHallReservation);
                    currentHallCapacity=0;


                }
               if(halls.isEmpty()){
                   continue;
               }



                currentHallCapacity+=reservation;
                currentHallReservation.add(reservation);
           }else{
               halls.offer(current);
           }

        }







    }

    private static void printHall(Deque<String> halls, Deque<Integer> currentHallReservation) {
        System.out.print(halls.poll()+" -> ");
        while (!currentHallReservation.isEmpty()) {
            if(currentHallReservation.size()==1){
                System.out.print(currentHallReservation.remove());
            }else{
                System.out.print(currentHallReservation.remove()+", ");
            }

        }
        System.out.println();
    }

    private static Deque<String> initializeDeque(String[] input, int n) {
        Deque<String>stack=new ArrayDeque<>();
        for (int i = 0; i <input.length ; i++) {
            stack.push(input[i]);

        }
        return stack;
    }
}
