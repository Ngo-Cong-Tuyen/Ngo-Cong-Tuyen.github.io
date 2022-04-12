import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {

    private static String hostNane = "localhost:8080";
    private static String dbName = "library";
    private static String username= "root";
    private static String password = "123";

    private static String url = "jdbc:mysql://"+ hostNane + "/" + dbName;

    public static Connection getConnect(){
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public  static void closeConnect(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
