import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TronRacers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(reader.readLine());


        String[][] matrix=new String[n][];

        for (int i = 0; i <n ; i++) {
            String[] input=reader.readLine().split("");
                matrix[i]=input;



        }
        int firstPlayerPositionRow=0;
        int firstPlayerPositionCol=0;
        int secondPlayerPositionRow=0;
        int secondPlayerPositionCol=0;



        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                if(matrix[i][j].equals("f")){
                    firstPlayerPositionRow=i;
                    firstPlayerPositionCol=j;
                }else if (matrix[i][j].equals("s")){
                    secondPlayerPositionRow=i;
                    secondPlayerPositionCol=j;
                }
            }

        }


        boolean isFirstPlayerAlive=true;
        boolean isSecondPlayerAlive=true;

        while (isFirstPlayerAlive && isSecondPlayerAlive){
            String[]input=reader.readLine().split(" ");
            String firstPlayerCommand=input[0];
            String secondPlayerCommand=input[1];
            boolean isSafeForFirstPlayer=true;
            boolean isSafeForSecondPlayer=true;
            switch (firstPlayerCommand){
                case"down":
                    if(firstPlayerPositionRow+1<matrix.length){
                       isSafeForFirstPlayer= isSafeDown(firstPlayerPositionRow,firstPlayerPositionCol,matrix);
                        if(isSafeForFirstPlayer){
                            firstPlayerPositionRow++;
                            matrix[firstPlayerPositionRow][firstPlayerPositionCol]="f";

                        }else{
                            firstPlayerPositionRow++;
                            matrix[firstPlayerPositionRow][firstPlayerPositionCol]="x";
                            printMatrix(matrix);
                           return;
                        }

                    }else{
                        firstPlayerPositionRow=0;
                        isSafeForFirstPlayer= isSafeDown(firstPlayerPositionRow,firstPlayerPositionCol,matrix);
                        if(isSafeForFirstPlayer){
                            matrix[firstPlayerPositionRow][firstPlayerPositionCol]="f";
                        }else{
                            matrix[firstPlayerPositionRow][firstPlayerPositionCol]="x";
                            printMatrix(matrix);
                            return;
                        }
                    }



                    break;

                case "up":
                    if(firstPlayerPositionRow-1>=0){
                        firstPlayerPositionRow--;
                        isSafeForFirstPlayer= isSafeDown(firstPlayerPositionRow,firstPlayerPositionCol,matrix);
                        if(isSafeForFirstPlayer){
                            matrix[firstPlayerPositionRow][firstPlayerPositionCol]="f";
                        }else{
                            matrix[firstPlayerPositionRow][firstPlayerPositionCol]="x";
                            printMatrix(matrix);
                            return;
                        }

                    }else{
                        firstPlayerPositionRow=matrix.length-1;
                        isSafeForFirstPlayer= isSafeUp(firstPlayerPositionRow,firstPlayerPositionCol,matrix);
                        if(isSafeForFirstPlayer){
                            matrix[firstPlayerPositionRow][firstPlayerPositionCol]="f";
                        }else{
                            matrix[firstPlayerPositionRow][firstPlayerPositionCol]="x";
                            printMatrix(matrix);
                            return;
                        }
                    }

                    break;

                case "right":
                    if(firstPlayerPositionCol+1<matrix[firstPlayerPositionRow].length){
                        firstPlayerPositionCol++;
                        isSafeForFirstPlayer= isSafeRight(firstPlayerPositionRow,firstPlayerPositionCol,matrix);
                        if(isSafeForFirstPlayer){

                            matrix[firstPlayerPositionRow][firstPlayerPositionCol]="f";
                        }else{
                            matrix[firstPlayerPositionRow][firstPlayerPositionCol]="x";
                            printMatrix(matrix);
                            return;
                        }
                    }else{
                        firstPlayerPositionCol=0;
                        isSafeForFirstPlayer=isSafeRight(firstPlayerPositionRow,firstPlayerPositionCol,matrix);
                        if(isSafeForFirstPlayer){
                            matrix[firstPlayerPositionRow][firstPlayerPositionCol]="f";
                        }else{
                            matrix[firstPlayerPositionRow][firstPlayerPositionCol]="x";
                            printMatrix(matrix);
                            return;
                        }
                    }
                    break;

                case"left":
                    if(firstPlayerPositionCol-1>=0){
                        firstPlayerPositionCol--;
                        isSafeForFirstPlayer= isSafeLeft(firstPlayerPositionRow,firstPlayerPositionCol,matrix);
                        if(isSafeForFirstPlayer){
                            matrix[firstPlayerPositionRow][firstPlayerPositionCol]="f";
                        }else{
                            matrix[firstPlayerPositionRow][firstPlayerPositionCol]="x";
                            printMatrix(matrix);
                            return;
                        }

                    }else{
                        firstPlayerPositionCol=matrix[firstPlayerPositionRow].length-1;
                        isSafeForFirstPlayer= isSafeLeft(firstPlayerPositionRow,firstPlayerPositionCol,matrix);
                        if(isSafeForFirstPlayer){
                            matrix[firstPlayerPositionRow][firstPlayerPositionCol]="f";
                        }else{
                            matrix[firstPlayerPositionRow][firstPlayerPositionCol]="x";
                            printMatrix(matrix);
                            return;
                        }
                    }


                    break;
            }











            switch (secondPlayerCommand){
                case"down":
                    if(secondPlayerPositionRow+1<matrix.length){
                        isSafeForSecondPlayer= isSafeDownSecond(secondPlayerPositionRow,secondPlayerPositionCol,matrix);
                        if(isSafeForSecondPlayer){
                            secondPlayerPositionRow++;
                            matrix[secondPlayerPositionRow][secondPlayerPositionCol]="s";

                        }else{
                            secondPlayerPositionRow++;
                            matrix[secondPlayerPositionRow][secondPlayerPositionCol]="x";
                            printMatrix(matrix);
                            return;
                        }

                    }else{
                        secondPlayerPositionRow=0;
                        isSafeForSecondPlayer= isSafeDownSecond(secondPlayerPositionRow,secondPlayerPositionCol,matrix);
                        if(isSafeForSecondPlayer){
                            matrix[secondPlayerPositionRow][secondPlayerPositionCol]="s";
                        }else{
                            matrix[secondPlayerPositionRow][secondPlayerPositionCol]="x";
                            printMatrix(matrix);
                            return;
                        }
                    }



                    break;

                case "up":
                    if(secondPlayerPositionRow-1>=0){
                        secondPlayerPositionRow--;
                        isSafeForFirstPlayer= isSafeDownSecond(secondPlayerPositionRow,secondPlayerPositionCol,matrix);
                        if(isSafeForSecondPlayer){
                            matrix[secondPlayerPositionRow][secondPlayerPositionCol]="s";
                        }else{
                            matrix[secondPlayerPositionRow][secondPlayerPositionCol]="x";
                            printMatrix(matrix);
                            return;
                        }

                    }else{
                        secondPlayerPositionRow=matrix.length-1;
                        isSafeForSecondPlayer= isSafeUpSecond(secondPlayerPositionRow,secondPlayerPositionCol,matrix);
                        if(isSafeForSecondPlayer){
                            matrix[secondPlayerPositionRow][secondPlayerPositionCol]="s";
                        }else{
                            matrix[secondPlayerPositionRow][secondPlayerPositionCol]="x";
                            printMatrix(matrix);
                            return;
                        }
                    }

                    break;

                case "right":
                    if(secondPlayerPositionCol+1<matrix[secondPlayerPositionRow].length){
                        secondPlayerPositionCol++;
                        isSafeForSecondPlayer= isSafeRightSecond(secondPlayerPositionRow,secondPlayerPositionCol,matrix);
                        if(isSafeForSecondPlayer){

                            matrix[secondPlayerPositionRow][secondPlayerPositionCol]="s";
                        }else{
                            matrix[secondPlayerPositionRow][secondPlayerPositionCol]="x";
                            printMatrix(matrix);
                            return;
                        }
                    }else{
                        secondPlayerPositionCol=0;
                        isSafeForSecondPlayer=isSafeRightSecond(secondPlayerPositionRow,secondPlayerPositionCol,matrix);
                        if(isSafeForSecondPlayer){
                            matrix[secondPlayerPositionRow][secondPlayerPositionCol]="f";
                        }else{
                            matrix[secondPlayerPositionRow][secondPlayerPositionCol]="x";
                            printMatrix(matrix);
                            return;
                        }
                    }
                    break;

                case"left":
                    if(secondPlayerPositionCol-1>=0){
                        secondPlayerPositionCol--;
                        isSafeForSecondPlayer= isSafeLeftSecond(secondPlayerPositionRow,secondPlayerPositionCol,matrix);
                        if(isSafeForSecondPlayer){
                            matrix[secondPlayerPositionRow][secondPlayerPositionCol]="s";
                        }else{
                            matrix[secondPlayerPositionRow][secondPlayerPositionCol]="x";
                            printMatrix(matrix);
                            return;
                        }

                    }else{
                        secondPlayerPositionCol=matrix[secondPlayerPositionRow].length-1;
                        isSafeForSecondPlayer= isSafeLeftSecond(secondPlayerPositionRow,secondPlayerPositionCol,matrix);
                        if(isSafeForSecondPlayer){
                            matrix[secondPlayerPositionRow][secondPlayerPositionCol]="s";
                        }else{
                            matrix[secondPlayerPositionRow][secondPlayerPositionCol]="x";
                            printMatrix(matrix);
                            return;
                        }
                    }


                    break;
            }





        }



    }
    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                System.out.print(matrix[i][j]);

            }
            System.out.println();
        }
    }

    private static boolean isSafeLeftSecond(int secondPlayerPositionRow, int secondPlayerPositionCol, String[][] matrix) {
        if(!matrix[secondPlayerPositionRow][secondPlayerPositionCol].equals("s")){
            return true;
        }
        return false;
    }

    private static boolean isSafeRightSecond(int secondPlayerPositionRow, int secondPlayerPositionCol, String[][] matrix) {
        if(!matrix[secondPlayerPositionRow][secondPlayerPositionCol].equals("s")){
            return true;

        }
        return false;
    }



    public static boolean isSafeDownSecond(int secondpositionRow,int secondpositionCol,String[][] matrix){

        if(!matrix[secondpositionRow+1][secondpositionCol].equals("s")){

            return true;
        }
        return false;


    }
    public static boolean isSafeUpSecond(int secondpositionRow,int secondpositionCol,String[][] matrix){

        if(!matrix[secondpositionRow][secondpositionCol].equals("s")){

            return true;
        }
        return false;


    }
































    private static boolean isSafeLeft(int firstPlayerPositionRow, int firstPlayerPositionCol, String[][] matrix) {
        if(!matrix[firstPlayerPositionRow][firstPlayerPositionCol].equals("s")){
            return true;
        }
        return false;
    }

    private static boolean isSafeRight(int firstPlayerPositionRow, int firstPlayerPositionCol, String[][] matrix) {
        if(!matrix[firstPlayerPositionRow][firstPlayerPositionCol].equals("s")){
            return true;

        }
        return false;
    }



    public static boolean isSafeDown(int positionRow,int positionCol,String[][] matrix){

        if(!matrix[positionRow+1][positionCol].equals("s")){

            return true;
        }
        return false;


    }
    public static boolean isSafeUp(int positionRow,int positionCol,String[][] matrix){

        if(!matrix[positionRow][positionCol].equals("s")){

            return true;
        }
        return false;


    }



}
