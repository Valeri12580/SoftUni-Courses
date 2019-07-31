package blackBoxIntegerFix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String input="";

        Constructor constructor=BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);
         BlackBoxInt box= (BlackBoxInt) constructor.newInstance();

        Field field=BlackBoxInt.class.getDeclaredField("innerValue");
        field.setAccessible(true);


        while (!"END".equals(input=reader.readLine())){
            String[]inputToArray=input.split("_");
            String command=inputToArray[0];
            int value= Integer.parseInt(inputToArray[1]);
            Method method=null;


            switch (command){
                case "add":
                    method=BlackBoxInt.class.getDeclaredMethod("add", int.class);
                    method.setAccessible(true);
                    method.invoke(box,value);


                    System.out.println(field.getInt(box));



                    break;


                case "subtract":
                    method=BlackBoxInt.class.getDeclaredMethod("subtract",int.class);
                    method.setAccessible(true);
                    method.invoke(box,value);

                    System.out.println(field.getInt(box));

                    break;



                case "divide":
                    method=BlackBoxInt.class.getDeclaredMethod("divide", int.class);
                    method.setAccessible(true);
                    method.invoke(box,value);

                    System.out.println(field.getInt(box));

                    break;


                case "multiply":
                    method=BlackBoxInt.class.getDeclaredMethod("multiply", int.class);
                    method.setAccessible(true);
                    method.invoke(box,value);

                    System.out.println(field.getInt(box));
                    break;


                case "rightShift":
                    method=BlackBoxInt.class.getDeclaredMethod("rightShift", int.class);
                    method.setAccessible(true);
                    method.invoke(box,value);

                    System.out.println(field.getInt(box));
                    break;


                case "leftShift":
                    method=BlackBoxInt.class.getDeclaredMethod("leftShift", int.class);
                    method.setAccessible(true);
                    method.invoke(box,value);

                    System.out.println(field.getInt(box));

                    break;
            }


        }



    }
}
