import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MatrixOfPalindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int[]parameters= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows=parameters[0];
        int columns=parameters[1];

        String[][] letters=new String[rows][columns];



        for (int row = 0; row <rows; row++) {
            char rowLetter= (char) ('a'+row);


            for (int col = 0; col <columns ; col++) {
                char middleLetter=(char)(rowLetter+col);
                letters[row][col]=String.valueOf(rowLetter);
                for (int i = 0; i < 3; i++) {
                    if(i==1){
                        letters[row][col]+=middleLetter;
                    }else if (i==2){

                        letters[row][col]+=rowLetter;
                    }

                }

            }

        }

        for (String[] letter : letters) {
            for (int i = 0; i <letter.length ; i++) {
                System.out.print(letter[i]+" ");
            }
            System.out.println();

        }
    }
}
