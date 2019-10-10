import java.io.*;
import java.math.BigInteger;

public class SumBytes {
    public static void main(String[] args) {
        File file=new File("C:\\Users\\Valer\\OneDrive\\Работен плот\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        File fileOut=new File("C:\\\\Users\\\\Valer\\\\OneDrive\\\\Работен плот\\\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\zaTesta.txt");


        try {
            BufferedReader reader=new BufferedReader(new FileReader(file));
            FileWriter writer=new FileWriter(fileOut);
            BigInteger ascii=BigInteger.ZERO;
            String line=reader.readLine();
            while(line != null){
                for (int i = 0; i <line.length() ; i++) {
                    int currentNum=line.charAt(i);
                    ascii=ascii.add(BigInteger.valueOf(currentNum));
                }

                line=reader.readLine();
            }
            writer.write(String.valueOf(ascii));
            reader.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
