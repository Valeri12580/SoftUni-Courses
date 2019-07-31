package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String command="";
		Field[] fields=RichSoilLand.class.getDeclaredFields();



		while (!"HARVEST".equals(command=reader.readLine())){

		if(command.equals("all")){
			Arrays.stream(fields).forEach(e->System.out.println(String.format("%s %s %s",Modifier.toString(e.getModifiers()),e.getType().getSimpleName(),e.getName())));

		}else{
			String finalCommand = command;
			Arrays.stream(fields).filter(e->Modifier.toString(e.getModifiers()).equals(finalCommand)).forEach(e->
					System.out.println(String.format("%s %s %s",Modifier.toString(e.getModifiers()),e.getType().getSimpleName(),e.getName())));
		}



		}

	}



}
