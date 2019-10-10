package highQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        Class<Reflection> aClass=Reflection.class;
        Field[] field=aClass.getDeclaredFields();
        Method[] methods=aClass.getDeclaredMethods();


Arrays.stream(field).filter(e->!Modifier.isPrivate(e.getModifiers())).sorted(Comparator.comparing(Field::getName)).forEach(e-> System.out.println(String.format("%s must be private!",e.getName())));
       Arrays.stream(methods).filter(e->e.getName().startsWith("get") && !Modifier.isPublic(e.getModifiers())).sorted(Comparator.comparing(Method::getName)).forEach(e->System.out.println(String.format("%s must be public!",e.getName())));

        Arrays.stream(methods).filter(e->e.getName().startsWith("set") && !Modifier.isPrivate(e.getModifiers())).sorted(Comparator.comparing(Method::getName)).forEach(e->System.out.println(String.format("%s must be private!",e.getName())));

        Main main=new Main();











    }

}
