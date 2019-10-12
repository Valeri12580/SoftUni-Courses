import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculateRectangleArea {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        double width=Double.parseDouble(reader.readLine());
        double height=Double.parseDouble(reader.readLine());

        System.out.println(result((int)width,(int)height));




    }

    static int result(int width,int height){
        return width*height;
    }
}
