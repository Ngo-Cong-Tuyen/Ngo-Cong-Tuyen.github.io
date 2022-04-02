import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {

    private String hostname = "localhost:8080";
    private String dbName ="blog";
    private String username = "root";
    private String password = "123";

    private String url = "jdbc:mysql://"+ hostname +"/" + dbName;

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}