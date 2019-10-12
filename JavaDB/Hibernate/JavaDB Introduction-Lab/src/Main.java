import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner=new Scanner(System.in);
       Properties properties=new Properties();
       properties.setProperty("user","root");
       properties.setProperty("password","1234");

       Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/soft_uni?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",properties);
    PreparedStatement statement=connection.prepareStatement("SELECT * FROM employees WHERE first_name=?");
    String name=scanner.nextLine();
    statement.setString(1,name);

    ResultSet result=statement.executeQuery();
        if(!result.next()){
            System.out.println("Invalid input");
        }else{
            System.out.println(result.getString("first_name"));
        }

    }
}
