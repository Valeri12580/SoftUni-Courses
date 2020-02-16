package demo;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner=new Scanner(System.in);
        Properties properties=new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","1234");
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", properties);
        PreparedStatement statement=connection.prepareStatement("Select u.*, g.name ,g.duration ,Count(g.id) as count_games FROM users  as u JOIN users_games  as ug ON u.id = ug.user_id  JOIN games as g ON ug.game_id = g.id WHERE u.user_name = ? GROUP BY u.user_name");
        String username = scanner.nextLine();
        statement.setString(1,username);

        ResultSet result=statement.executeQuery();
        result.next();
        try{
            System.out.printf("User: %s\n%s %s has played %d games.",result.getString("user_name"),result.getString("first_name"),result.getString("last_name"),result.getInt("count_games"));

        }catch(Exception e){
            System.out.println("No results!");
        }


    }
}
