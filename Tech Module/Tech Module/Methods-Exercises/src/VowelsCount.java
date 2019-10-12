import java.util.Arrays;
import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String word=scanner.nextLine().toLowerCase();
        getVowels(word);


    }

    static void getVowels(String word){
        int counter=0;
        for (int i = 0; i <word.length(); i++) {
            if (String.valueOf(word.charAt(i)).contains("a")||String.valueOf(word.charAt(i)).contains("o")||String.valueOf(word.charAt(i)).contains("u")||
            String.valueOf(word.charAt(i)).contains("e")||String.valueOf(word.charAt(i)).contains("i")){
                counter++;
            }

        }

        System.out.println(counter);

    }
}
