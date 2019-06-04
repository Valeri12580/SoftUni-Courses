import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String pathInput="C:\\Users\\Valer\\OneDrive\\Работен плот\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOutput="C:\\Users\\Valer\\OneDrive\\Работен плот\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\4zacha.txt";
        try(Scanner scanner=new Scanner(new FileReader(pathInput))) {
            PrintWriter writer=new PrintWriter(pathOutput);
            while (scanner.hasNext()) {
                scanner.next();
                if(scanner.hasNextInt()){
                    writer.println(scanner.nextInt());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
