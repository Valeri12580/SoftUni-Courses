package gettersAndSetters;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Class aClass=Reflection.class;
        List<Method>getters=new ArrayList<>();
        List<Method>setters=new ArrayList<>();


        Method[] allMethods = aClass.getDeclaredMethods();


        for (Method method : allMethods) {
            if(method.getName().startsWith("get")){
                getters.add(method);
            }else if (method.getName().startsWith("set")){
                setters.add(method);
            }

        }

        getters.stream().sorted(Comparator.comparing(Method::getName)).forEach(e->
                System.out.println(String.format("%s will return class %s",e.getName(),e.getReturnType().getName())));




        setters.stream().sorted(Comparator.comparing(Method::getName)).forEach(e->{
            System.out.println(String.format("%s and will set field of class %s",e.getName(),e.getParameterTypes()[0].getName()));

        });
    }
}
