import jdk.jshell.Snippet;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BlogManager {
    ConnectDatabase connectDatabase = new ConnectDatabase();
    Connection conn;

    public void openConnect(){
        conn = connectDatabase.connect();
    }

    public void getBlog(String query){
        openConnect();

        try {
            Statement stm = conn.createStatement();

            ResultSet result = stm.executeQuery(query);

            while (result.next()) {
                int id = result.getInt("id");
                String title = result.getString("title");
                String content = result.getString("content");
                String description = result.getString("description");
                Date create_at = result.getDate("create_at");
                String status = result.getString("status");

                System.out.println(id + " - " + title+ " - " + content+ " - " +description+ " - " + create_at+ " - " + status);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertNewPost(Post newPost){
        openConnect();
        String query = "INSERT INTO `post`(`id`, `title`, `content`, `description`, `thumnail`, `id_category`, `id_author`, `create_at`, `status`) " +
                "VALUES (null,?,?,?,null,null,null,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, newPost.getThumnail());
            pstm.setString(2,newPost.getContent());
            pstm.setString(3,newPost.getDescription());
            pstm.setDate(4, new java.sql.Date(newPost.getCreate_at().getTime()));
            pstm.setString(5, newPost.getStatus());

            int row = pstm.executeUpdate();

            if(row != 0){
                System.out.println("Thêm thành công: " + row);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Post createNewPost() {
        Post post = new Post();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Title:");
        String title = scanner.nextLine();
        post.setTitle(title);

        System.out.println("Content:");
        String content = scanner.nextLine();
        post.setContent(content);

        System.out.println("description:");
        String description = scanner.nextLine();
        post.setDescription(description);

        System.out.println("Create_at:");
        String create_at = scanner.nextLine();

        Date date = null;
        try {
            SimpleDateFormat sdf_ddMMyy = new SimpleDateFormat("dd/MM/yyyy");
            date = sdf_ddMMyy.parse(create_at);
        } catch (Exception e) {
        }
        post.setCreate_at(date);
        System.out.println("Status:");
        String status = scanner.nextLine();
        return post;
    }

    public void delete(int id){
        openConnect();
        String query ="DELETE FROM `post` WHERE id="+id;
        try {
            Statement stm = conn.createStatement();

            int row = stm.executeUpdate(query);

            if(row != 0){
                System.out.println("Xóa thành công: " + row);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
