import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class voinaNumberGame {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));


        Set<Integer>firstPlayer= new LinkedHashSet<>();
        Set<Integer>secondPlayer= new LinkedHashSet<>();
        Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(firstPlayer::add);
        Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(secondPlayer::add);
        for (int i = 0; i <50 ; i++) {
            Iterator<Integer>firstIterator=firstPlayer.iterator();
            Iterator<Integer>secondIterator=secondPlayer.iterator();
            if(firstPlayer.isEmpty() || secondPlayer.isEmpty()){
                break;
            }
            int firstPlayerValue=firstIterator.next();
            firstPlayer.remove(firstPlayerValue);
            int secondPlayerValue=secondIterator.next();
           secondPlayer.remove(secondPlayerValue);
           if(firstPlayerValue>secondPlayerValue){
               firstPlayer.add(firstPlayerValue);
               firstPlayer.add(secondPlayerValue);
           }else if (secondPlayerValue>firstPlayerValue){
               secondPlayer.add(firstPlayerValue);
               secondPlayer.add(secondPlayerValue);

           }else{
               firstPlayer.add(firstPlayerValue);
               secondPlayer.add(secondPlayerValue);
           }


        }
        if(firstPlayer.size()>secondPlayer.size()){
            System.out.println("First player win!");
        }else if (secondPlayer.size()>firstPlayer.size()){
            System.out.println("Second player win!");
        }else{
            System.out.println("Draw!");
        }
    }
}
