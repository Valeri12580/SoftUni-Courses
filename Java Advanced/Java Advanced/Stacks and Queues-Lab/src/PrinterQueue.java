import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class PrinterQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String>queue=new ArrayDeque<>();


        String input="";
        while (!"print".equals(input=reader.readLine())){
            if(input.equals("cancel")){
                if(!queue.isEmpty()){
                    System.out.println("Canceled "+queue.poll());
                }else{
                    System.out.println("Printer is on standby");

                }

            }else{
                queue.add(input);
            }
        }
        queue.stream().forEach(e->{
            System.out.println(e);
        });
    }
}
