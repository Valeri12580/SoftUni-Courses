import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardGame {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Integer>handOne= Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer>handTwo= Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int i=0;
        while (handOne.size()!=0 && handTwo.size()!=0) {
            if(handOne.get(i)>handTwo.get(i)){
                handOne.add(handOne.get(i));
                handOne.remove(i);
                handOne.add(handTwo.get(i));
                handTwo.remove(i);
            }else if (handOne.get(i)<handTwo.get(i)){
                handTwo.add(handTwo.get(i));
                handTwo.remove(i);
                handTwo.add(handOne.get(i));
                handOne.remove(i);
            }else{
                handOne.remove(i);
                handTwo.remove(i);

            }

        }
        int sum=0;
        if(handOne.size()!=0){
            gettingResult(handOne,"First");
        }else{
            gettingResult(handTwo,"Second");
        }






    }

    static void gettingResult(List<Integer>winnerHand,String woner){
        int sum=0;
        for (int n:winnerHand) {
            sum+=n;
        }
        System.out.println(String.format("%s player wins! Sum: %d",woner,sum));
    }
}
