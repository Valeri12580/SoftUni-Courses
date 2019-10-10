import java.util.Scanner;
public class ifelse {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double numbtoConvert=Double.parseDouble(scanner.nextLine());
        String firstValue=scanner.nextLine();
        String secondValue=scanner.nextLine();
        double defaultValue=0;
        double  outputValue=0;
        if (firstValue.equals("m")){
            defaultValue=numbtoConvert;
        }else if (firstValue.equals("mm")){
            defaultValue=numbtoConvert/1000;

        }else if (firstValue.equals("cm")){
            defaultValue=numbtoConvert/100;
        }else if (firstValue.equals("mi")){
            defaultValue=numbtoConvert/0.000621371192;

        }else if (firstValue.equals("in")){
            defaultValue=numbtoConvert/39.3700787;
        }else if (firstValue.equals("km")){
            defaultValue=numbtoConvert/0.001;
        }else if(firstValue.equals("ft")){
            defaultValue=numbtoConvert/3.2808399;
        }else if (firstValue.equals("yd")){
            defaultValue=numbtoConvert/1.0936133;
        }
        if (secondValue.equals("m")){
            outputValue=defaultValue;
        }else if (secondValue.equals("mm")){
            outputValue=defaultValue*1000;

        }else if (secondValue.equals("cm")){
            outputValue=defaultValue*100;
        }else if (secondValue.equals("mi")){
            outputValue=defaultValue*0.000621371192;

        }else if (secondValue.equals("in")){
            outputValue=defaultValue*39.3700787;
        }else if (secondValue.equals("km")){
            outputValue=defaultValue*0.001;
        }else if(secondValue.equals("ft")){
            outputValue=defaultValue*3.2808399;
        }else if (secondValue.equals("yd")) {
            outputValue = defaultValue * 1.0936133;
        }
        System.out.printf("%.8f",outputValue);


    }
}

