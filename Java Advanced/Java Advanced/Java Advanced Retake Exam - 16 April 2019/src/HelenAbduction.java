import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelenAbduction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int parisEnergy=Integer.parseInt(reader.readLine());
        int sizeOfMatrix=Integer.parseInt(reader.readLine());
        String[][]matrix=new String[sizeOfMatrix][];

        for (int i = 0; i <sizeOfMatrix ; i++) {
            String[]input=reader.readLine().split("");
            for (int j = 0; j <input.length ; j++) {

            }
            matrix[i]=input;
        }

        int positionOfParisRow=0;
        int positionOfParisCol=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j].equals("P")){
                    positionOfParisRow=i;
                    positionOfParisCol=j;
                    break;
                }
            }
        }
        boolean isReachedHelen=false;
        matrix[positionOfParisRow][positionOfParisCol]="-";
        while (parisEnergy>0 && !isReachedHelen){

            String[] input=reader.readLine().split(" ");
            String command=input[0];
            int row=Integer.parseInt(input[1]);
            int col=Integer.parseInt(input[2]);

            matrix[row][col]="S";
            boolean canHeMove=false;

            switch (command){
                case "up":
                    canHeMove=test(command,matrix,positionOfParisRow,positionOfParisCol);
                    parisEnergy-=1;
                    if(canHeMove){
                        positionOfParisRow--;
                        if(matrix[positionOfParisRow][positionOfParisCol].equals("S")){
                            parisEnergy-=2;
                            if(parisEnergy<=0){
                                matrix[positionOfParisRow][positionOfParisCol]="X";
                            }else{
                                matrix[positionOfParisRow][positionOfParisCol]="-";
                            }

                        }

                    }


                    break;

                case "down":
                   canHeMove=test(command,matrix,positionOfParisRow,positionOfParisCol);
                    parisEnergy-=1;
                    if(canHeMove){
                        positionOfParisRow++;
                        if(matrix[positionOfParisRow][positionOfParisCol].equals("S")){
                            parisEnergy-=2;
                            if(parisEnergy<=0){
                                matrix[positionOfParisRow][positionOfParisCol]="X";
                            }else{
                                matrix[positionOfParisRow][positionOfParisCol]="-";
                            }

                        }

                    }

                    break;

                case "left":
                    canHeMove=test(command,matrix,positionOfParisRow,positionOfParisCol);
                    parisEnergy-=1;
                    if(canHeMove){
                        positionOfParisCol--;
                        if(matrix[positionOfParisRow][positionOfParisCol].equals("S")){
                            parisEnergy-=2;
                            if(parisEnergy<=0){
                                matrix[positionOfParisRow][positionOfParisCol]="X";
                            }else{
                                matrix[positionOfParisRow][positionOfParisCol]="-";
                            }

                        }

                    }

                    break;

                case "right":
                    canHeMove=test(command,matrix,positionOfParisRow,positionOfParisCol);
                    parisEnergy-=1;
                    if(canHeMove){
                        positionOfParisRow++;
                        if(matrix[positionOfParisRow][positionOfParisCol].equals("S")){
                            parisEnergy-=2;
                            if(parisEnergy<=0){
                                matrix[positionOfParisRow][positionOfParisCol]="X";
                            }else{
                                matrix[positionOfParisRow][positionOfParisCol]="-";
                            }

                        }

                    }

                    break;
            }
            if(parisEnergy<=0){
                matrix[positionOfParisRow][positionOfParisCol]="X";
            }
            if(matrix[positionOfParisRow][positionOfParisCol].equals("H")){
                isReachedHelen=true;
                matrix[positionOfParisRow][positionOfParisCol]="-";

            }

        }
        if(isReachedHelen){
            System.out.println(String.format("Paris has successfully abducted Helen! Energy left: %d",parisEnergy));
        }else{
            System.out.printf("Paris died at %d;%d.%n",positionOfParisRow,positionOfParisCol);
        }

        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }


    }




    private static boolean test(String command,String[][]matrix,int positionParisRow,int positionParisCol) {
        switch (command){
            case "up":
                if(positionParisRow-1>=0){
                    return true;
                }
                return false;



            case "down":
                if(positionParisRow+1<matrix.length){
                    return true;

                }
                return false;


            case "left":
                if(positionParisCol-1>=0){
                    return true;
                }
                return false;



            case "right":
                if(positionParisCol+1<matrix[positionParisRow].length){
                    return true;

                }
                return false;


                default:
                    return false;
        }
    }
}
