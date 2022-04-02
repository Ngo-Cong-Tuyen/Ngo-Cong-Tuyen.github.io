import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        ConnectDatabase connectDatabase = new ConnectDatabase();

        Connection conn = connectDatabase.connect();

//        if (conn != null) {
//            System.out.println("Connection sucessfull");
//        } else {
//            System.out.println("Connection failed");
//        }

        String query = "SELECT * FROM `users`";

        try {
            Statement stm = conn.createStatement();

            ResultSet result= stm.executeQuery(query);

            while (result.next()) {
                int id = result.getInt("id");
                String username= result.getString("username");
                String email = result.getString("email");
                String password =  result.getString("password");

                System.out.println(id + " - " + username + " - " + email + " - " + password);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}