import java.io.*;

public class LineNumbers {
    public static void main(String[] args) {
        File file=new File("C:\\Users\\Valer\\OneDrive\\Работен плот\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt");
        File fileOut=new File("C:\\Users\\Valer\\OneDrive\\Работен плот\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\zaTesta.txt");


        try {
            BufferedReader reader=new BufferedReader(new FileReader(file));
            PrintWriter writer=new PrintWriter(fileOut);
            String line=reader.readLine();
            int count=1;
            while (line!=null){
                writer.printf("%d. %s%n",count,line);

                count++;
                line=reader.readLine();

            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
