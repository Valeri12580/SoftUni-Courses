import java.util.*;

public class softuniParty {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        Set<String>normalGuests=new TreeSet<>();

        Set<String>vipGuests=new TreeSet<>();

        String input;

        while (!"PARTY".equals(input=scanner.nextLine())){
            if(Character.isDigit(input.charAt(0))){
                vipGuests.add(input);
            }else{
                normalGuests.add(input);
            }
        }


        while (!"END".equals(input=scanner.nextLine())){
            if (!(vipGuests.contains(input) || normalGuests.contains(input))) {
                continue;
            }
            if(Character.isDigit(input.charAt(0))){
                vipGuests.remove(input);
            }else{
                normalGuests.remove(input);
            }
        }

        System.out.println(normalGuests.size()+vipGuests.size());

        vipGuests.forEach(System.out::println);
        normalGuests.forEach(System.out::println);
    }
}
