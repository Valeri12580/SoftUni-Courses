import java.io.*;
import java.nio.file.Path;

public class SumLines {
    public static void main(String[] args) {
        File file=new File("C:\\Users\\Valer\\OneDrive\\Работен плот\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        File fileOut=new File("C:\\\\Users\\\\Valer\\\\OneDrive\\\\Работен плот\\\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\zaTesta.txt");


        try {
            BufferedReader reader=new BufferedReader(new FileReader(file));
            FileWriter writer=new FileWriter(fileOut);
            String line=reader.readLine();
            while(line != null){
                int ascii=0;
                for (int i = 0; i <line.length() ; i++) {
                    ascii+=line.charAt(i);
                }
                System.out.println(ascii);
                writer.write(String.valueOf(ascii));
                writer.write(System.lineSeparator());
                line=reader.readLine();
            }
            reader.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
