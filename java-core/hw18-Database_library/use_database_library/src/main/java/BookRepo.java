import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookRepo {

    public ArrayList<Book> getAllBooks(){
        Connection conn = ConnectDatabase.getConnect();
        ArrayList<Book> list = new ArrayList<>();

        String query = "SELECT * FROM list_book";

        try {
            Statement stm = conn.createStatement();

            ResultSet result = stm.executeQuery(query);

            while (result.next()) {
                int id = result.getInt("id");
                String title = result.getString("title");
                String image = result.getString("image");
                String description = result.getString("description");
                String author = result.getString("author");
                int publishing_year = result.getInt("year_of_publication");
                String company = result.getString("company");
                String category = result.getString("category");

                list.add(new Book(id,title,image,description,author,publishing_year,company,category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectDatabase.closeConnect(conn);
        }

        return list;
    }
}
