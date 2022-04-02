import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    private String hostName= "localhost:8083";
    private String dbName= "user_manager";
    private String username= "root";
    private String password ="123";

    private String url= "jdbc:mysql://"+ hostName+"/"+dbName;

    public Connection connect(){
        Connection conn= null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:8083/user_manager", "root", "123");
//            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
