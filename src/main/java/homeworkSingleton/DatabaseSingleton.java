package homeworkSingleton;
import java.sql.*;

public class DatabaseSingleton {
    private static DatabaseSingleton instance;
    public Connection mysqlConnection;
    String user = "root";
    String password = "Villarroel1206";

    private DatabaseSingleton(){
        try {
            this.mysqlConnection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/rodrimock",user,password);
        } catch (SQLException e) {
            System.out.println("There is no connection to the database: User = " + user + " Password = " + password);
        }
    }

    public static DatabaseSingleton getInstance(){
        if(instance == null) instance = new DatabaseSingleton();
        return instance;
    }

    public void showTables(){
        try {
            Statement st = mysqlConnection.createStatement();
            ResultSet rs = st.executeQuery("select * from users");
            while (rs.next()){
                System.out.println(rs.getInt("PersonID")+"  "+rs.getString("FirstName")+"  "+rs.getString("LastName"));
            }
        } catch (SQLException e) {
            System.out.println("Couldn't execute query");
        }


    }
}
