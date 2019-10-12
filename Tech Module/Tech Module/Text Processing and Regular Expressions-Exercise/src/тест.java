import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class тест {
    public static void main(String[] args) {
        String name="IvanepedalIvaneGei";
        Pattern pattern=Pattern.compile("Ivan");

        Matcher matcher=pattern.matcher(name);
        double res=0.0;
        while (matcher.find()){
            res+=matcher.group(0).charAt(0);
        }
        System.out.println(res);

    }
}
