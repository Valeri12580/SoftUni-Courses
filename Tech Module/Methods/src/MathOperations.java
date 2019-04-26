import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class MathOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int num1=Integer.parseInt(reader.readLine());
        char operator =reader.readLine().charAt(0);
        int num2=Integer.parseInt(reader.readLine());
        System.out.printf("%s",new DecimalFormat("#.##").format(getResult(num1,num2,operator)));



    }

    static double getResult(double num1,double num2,char operator){
        switch (operator){
            case '+':
                return num1+num2;
            case '-':
                return  num1-num2;
            case '*':
                return num1*num2;
            case '/':
                return num1/num2;


        }
        return 0;

    }
}
