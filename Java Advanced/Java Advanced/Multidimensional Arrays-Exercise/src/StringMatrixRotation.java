import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StringMatrixRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] command = reader.readLine().split("[()]");
        List<String> wordsFromInput = new ArrayList<>();
        String commandForEnd = "";
        int maxLength = -1;
        while (!"END".equals(commandForEnd = reader.readLine())) {
            wordsFromInput.add(commandForEnd);
            if (commandForEnd.length() > maxLength) {
                maxLength = commandForEnd.length();
            }

        }


        char[][] charMatrix = new char[wordsFromInput.size()][maxLength];

        for (int row = 0; row < charMatrix.length; row++) {
            boolean isSmaller=false;

            String currentString = wordsFromInput.get(row);
            int lastindex=currentString.length();
            if(currentString.length()<maxLength){
                isSmaller=true;
            }

            for (int j = 0; j < currentString.length(); j++) {
                char currentChar = currentString.charAt(j);
                charMatrix[row][j] = currentChar;


            }
            if(isSmaller){
                while (lastindex<maxLength){
                    charMatrix[row][lastindex]=' ';
                    lastindex++;

                }

            }
        }

        int degree = Integer.parseInt(command[1]);
        int count = degree / 90;
        char[][]finalMatrix=new char [maxLength][charMatrix.length];
        if(degree==90 || degree%360==90) {

        }

    }


}

