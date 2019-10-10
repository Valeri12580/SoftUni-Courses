import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExerciseTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int stephenEnergy = 0;

        int sizeOfMatrix = Integer.parseInt(reader.readLine());
        String[][] matrix = new String[sizeOfMatrix][];

        String stephenSymbol="S";
        String blackHoleSymbol="S";
        int stephenPositionRow=0;
        int stephenPositionCol=0;

        int firstHolePositionRow=0;
        int firstHolePositionCol=0;
        int secondHolePositionRow=0;
        int secondHolePositionCol=0;
        int count=0;
        for (int i = 0; i < sizeOfMatrix; i++) {
            String[] input=reader.readLine().split("");
            matrix[i]=input;

            for (int j = 0; j <input.length ; j++) {
                if(input[j].equals("S")){
                    stephenPositionRow=i;
                    stephenPositionCol=j;

                }
                if(input[j].equals("O")){
                    count++;
                    if(count==1){
                        firstHolePositionRow=i;
                        firstHolePositionCol=j;
                    }else if (count==2){
                        secondHolePositionRow=i;
                        secondHolePositionCol=j;
                    }

                }

            }


        }
        boolean isLost=false;
        String numbers="0123456789";
        int starsCollected=0;


        while (!isLost && stephenEnergy<50){
            boolean isAlive=true;
            String command=reader.readLine();
            switch (command) {
                case "up":
                    isAlive=isSafeMethod(stephenPositionRow-1,stephenPositionCol,matrix);
                    if(isAlive){
                        matrix[stephenPositionRow][stephenPositionCol]="-";
                        stephenPositionRow--;
                        if(numbers.contains(matrix[stephenPositionRow][stephenPositionCol])){
                            stephenEnergy+=Integer.parseInt(matrix[stephenPositionRow][stephenPositionCol]);
                            matrix[stephenPositionRow][stephenPositionCol]="S";
                            starsCollected++;
                        }else if (stephenPositionRow==firstHolePositionRow &&stephenPositionCol==firstHolePositionCol){
                            stephenPositionRow=secondHolePositionRow;
                            stephenPositionCol=secondHolePositionCol;
                            matrix[firstHolePositionRow][firstHolePositionCol]="-";
                            matrix[stephenPositionRow][stephenPositionCol]="S";

                        }else if (stephenPositionRow==secondHolePositionRow || stephenPositionCol==secondHolePositionCol){
                            stephenPositionRow=secondHolePositionRow;
                            stephenPositionCol=secondHolePositionCol;
                            matrix[secondHolePositionRow][secondHolePositionCol]="-";
                            matrix[stephenPositionRow][stephenPositionCol]="S";

                        }

                    }else{
                        isLost=true;
                        matrix[stephenPositionRow][stephenPositionCol]="-";
                    }



                    break;

                case "down":
                    isAlive=isSafeMethod(stephenPositionRow+1,stephenPositionCol,matrix);
                    if(isAlive){
                        matrix[stephenPositionRow][stephenPositionCol]="-";
                        stephenPositionRow++;
                        if(numbers.contains(matrix[stephenPositionRow][stephenPositionCol])){
                            stephenEnergy+=Integer.parseInt(matrix[stephenPositionRow][stephenPositionCol]);
                            matrix[stephenPositionRow][stephenPositionCol]="S";
                            starsCollected++;
                        }else if (stephenPositionRow==firstHolePositionRow &&stephenPositionCol==firstHolePositionCol){
                            stephenPositionRow=secondHolePositionRow;
                            stephenPositionCol=secondHolePositionCol;
                            matrix[firstHolePositionRow][firstHolePositionCol]="-";
                            matrix[stephenPositionRow][stephenPositionCol]="S";

                        }else if (stephenPositionRow==secondHolePositionRow || stephenPositionCol==secondHolePositionCol){
                            stephenPositionRow=secondHolePositionRow;
                            stephenPositionCol=secondHolePositionCol;
                            matrix[secondHolePositionRow][secondHolePositionCol]="-";
                            matrix[stephenPositionRow][stephenPositionCol]="S";

                        }

                    }else{
                        isLost=true;
                        matrix[stephenPositionRow][stephenPositionCol]="-";
                    }

                    break;


                case "left":
                    isAlive=isSafeMethod(stephenPositionRow,stephenPositionCol-1,matrix);
                    if(isAlive){
                        matrix[stephenPositionRow][stephenPositionCol]="-";
                        stephenPositionCol--;
                        if(numbers.contains(matrix[stephenPositionRow][stephenPositionCol])){
                            stephenEnergy+=Integer.parseInt(matrix[stephenPositionRow][stephenPositionCol]);
                            matrix[stephenPositionRow][stephenPositionCol]="S";
                            starsCollected++;
                        }else if (stephenPositionRow==firstHolePositionRow &&stephenPositionCol==firstHolePositionCol){
                            stephenPositionRow=secondHolePositionRow;
                            stephenPositionCol=secondHolePositionCol;
                            matrix[firstHolePositionRow][firstHolePositionCol]="-";
                            matrix[stephenPositionRow][stephenPositionCol]="S";

                        }else if (stephenPositionRow==secondHolePositionRow || stephenPositionCol==secondHolePositionCol){
                            stephenPositionRow=secondHolePositionRow;
                            stephenPositionCol=secondHolePositionCol;
                            matrix[secondHolePositionRow][secondHolePositionCol]="-";
                            matrix[stephenPositionRow][stephenPositionCol]="S";

                        }

                    }else{
                        isLost=true;
                        matrix[stephenPositionRow][stephenPositionCol]="-";
                    }

                    break;


                case "right":
                    isAlive=isSafeMethod(stephenPositionRow,stephenPositionCol+1,matrix);
                    if(isAlive){
                        matrix[stephenPositionRow][stephenPositionCol]="-";
                        stephenPositionCol++;
                        if(numbers.contains(matrix[stephenPositionRow][stephenPositionCol])){
                            stephenEnergy+=Integer.parseInt(matrix[stephenPositionRow][stephenPositionCol]);
                            matrix[stephenPositionRow][stephenPositionCol]="S";
                            starsCollected++;
                        }else if (stephenPositionRow==firstHolePositionRow &&stephenPositionCol==firstHolePositionCol){
                            stephenPositionRow=secondHolePositionRow;
                            stephenPositionCol=secondHolePositionCol;
                            matrix[firstHolePositionRow][firstHolePositionCol]="-";
                            matrix[stephenPositionRow][stephenPositionCol]="S";

                        }else if (stephenPositionRow==secondHolePositionRow || stephenPositionCol==secondHolePositionCol){
                            stephenPositionRow=secondHolePositionRow;
                            stephenPositionCol=secondHolePositionCol;
                            matrix[secondHolePositionRow][secondHolePositionCol]="-";
                            matrix[stephenPositionRow][stephenPositionCol]="S";

                        }

                    }else{
                        isLost=true;
                        matrix[stephenPositionRow][stephenPositionCol]="-";

                    }


                    break;
            }


        }

        if(isLost){
            System.out.println("Bad news, the spaceship went to the void.");
        }else{
            System.out.println("Good news! Stephen succeeded in collecting enough star power!");
        }
        System.out.println(String.format("Star power collected: %d",stephenEnergy));

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);

            }
            System.out.println();

        }












    }

    private static boolean isSafeMethod(int newRow, int newCol, String[][] matrix) {

        return newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[newRow].length;
    }
}
