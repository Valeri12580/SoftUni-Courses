import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class Main {
    private static Properties props = new Properties();
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static Statement statement;
    private static String query;
    private static BufferedReader reader;
    private  static ResultSet result;

    public static void main(String[] args) throws IOException, SQLException {
         reader = new BufferedReader(new InputStreamReader(System.in));
        //firstExercise
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);

        //2.	Get Villains’ Names
//        secondExercise();

        //3.	Get Minion Names

//        thirdExercise();

        //4.	Add Minion
//        fourthExercise();

        //5.	Change Town Names Casing
//            fifthExercise();



        //7.	Print All Minion Names
        seventhExercise();




    }


    public  static void secondExercise() throws SQLException {
        query="SELECT v.name ,COUNT(mv.minion_id) as count\n" +
                "FROM villains as v\n" +
                "JOIN minions_villains  as mv\n" +
                "ON v.id=mv.villain_id\n" +
                "GROUP BY  mv.villain_id\n" +
                "HAVING count>15\n" +
                "ORDER BY count DESC;";
        preparedStatement = connection.prepareStatement(query);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            System.out.printf("%s %d%n", result.getString("name"), result.getInt("count"));
        }

    }

    public  static void thirdExercise() throws IOException, SQLException {
        System.out.println("Villain's id");
           int villainId=Integer.parseInt(reader.readLine());
           PreparedStatement villainStatement=connection.prepareStatement("SELECT v.name\n" +
                   "FROM villains as v\n" +
                   "WHERE v.id= ?");
           villainStatement.setInt(1,villainId);

           PreparedStatement minionsStatement=connection.prepareStatement("SELECT m.name,m.age\n" +
                   "FROM villains as v\n" +
                   "JOIN minions_villains mv on v.id = mv.villain_id\n" +
                   "JOIN minions m on mv.minion_id = m.id\n" +
                   "WHERE v.id=?");
           minionsStatement.setInt(1,villainId);

            result=villainStatement.executeQuery();
            if (result.next()){
                System.out.printf("Villain: %s%n",result.getString("name"));
                result=minionsStatement.executeQuery();

                int id=1;
                while (result.next()){
                    System.out.printf("%d. %s %d%n",id++,result.getString("name"),result.getInt("age"));
                }
            }else{
                System.out.println(String.format("No villain with ID %d exists in the database.",villainId));
            }

    }
    public  static void fourthExercise() throws IOException, SQLException {
        System.out.print("Minion:");
        String[] minionInfo=reader.readLine().split(" ");
        String minionName =minionInfo[0];
        int age=Integer.parseInt(minionInfo[1]);
        String town=minionInfo[2];
        System.out.print("Villain:");
        String[] villainInfo=reader.readLine().split(" ");
        String villainName=villainInfo[0];

        //check the town
        query="SELECT * FROM towns WHERE name=?";
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(1,town);
        result=preparedStatement.executeQuery();
        if(!result.next()){
            statement=connection.createStatement();
            int affectedRows=statement.executeUpdate(String.format("Insert into towns(name) VALUES (\"%s\")",town));
            if(affectedRows!=0){
                System.out.println(String.format("Town %s was added to the database.",town));
            }

        }


    }
    public  static void fifthExercise() throws IOException, SQLException {
        System.out.println("Country:");
        String country=reader.readLine();

        query=String.format("UPDATE towns SET name=UPPER(name) WHERE country=\"%s\"",country);
        statement=connection.createStatement();

        int affectedTowns=statement.executeUpdate(query);
        if(affectedTowns!=0){
            System.out.printf("%d town names were affected.%n",affectedTowns);
            preparedStatement=connection.prepareStatement("SELECT name FROM towns WHERE country=?");
            preparedStatement.setString(1,country);
            result=preparedStatement.executeQuery();
            List<String>townsResult=new ArrayList<>();
            while (result.next()){
                townsResult.add(result.getString("name"));
            }

            System.out.println(townsResult);
        }else{
            System.out.println("No town names were affected.");
        }

    }


    public static void seventhExercise() throws SQLException {
        query="SELECT name FROM minions";
        statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        result=statement.executeQuery(query);
        int resultLength=0;
        if (result.last()) {
            resultLength = result.getRow();
            result.beforeFirst();
        }

        for (int i = 1; i <=resultLength/2 ; i++) {
            result.absolute(i);
            System.out.println(result.getString("name"));


            result.absolute(resultLength-i+1);
            System.out.println(result.getString("name"));
        }







    }

}
