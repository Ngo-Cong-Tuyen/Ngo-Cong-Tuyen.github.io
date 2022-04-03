import jdk.jshell.Snippet;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BlogManager {
    ConnectDatabase connectDatabase = new ConnectDatabase();
    Connection conn;
    Scanner scanner = new Scanner(System.in);

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

    public Post getPost(int id) {
        openConnect();
        String query = "SELECT * FROM `post` WHERE id= " + id;
        Post post = null;
        int id_post = 0;
        try {
            Statement stm = conn.createStatement();

            ResultSet result = stm.executeQuery(query);

            while (result.next()) {
                id_post = result.getInt("id");
                String title = result.getString("title");
                String content = result.getString("content");
                String description = result.getString("description");
                int id_category = result.getInt("id_category");
                int id_author = result.getInt("id_author");
                Date create_at = result.getDate("create_at");
                String status = result.getString("status");
                post = new Post(id_post, title, content, description, null, id_category, id_author, create_at, status);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    public void insertNewPost(){
        openConnect();
        Post newPost = createNewPost();
        String query = "INSERT INTO `post`(`id`, `title`, `content`, `description`, `thumnail`, `id_category`, `id_author`, `create_at`, `status`) " +
                "VALUES (null,?,?,?,null,?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, newPost.getTitle());
            pstm.setString(2,newPost.getContent());
            pstm.setString(3,newPost.getDescription());
            pstm.setInt(4,newPost.getId_category());
            pstm.setInt(5,newPost.getId_author());
            pstm.setDate(6, (java.sql.Date) newPost.getCreate_at());
            pstm.setString(7, newPost.getStatus());

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

        System.out.println("Title:");
        String title = scanner.nextLine();
        post.setTitle(title);

        System.out.println("Content:");
        String content = scanner.nextLine();
        post.setContent(content);

        System.out.println("description:");
        String description = scanner.nextLine();
        post.setDescription(description);

        System.out.println("Id_category:");
        int id_category = scanner.nextInt();
        post.setId_category(id_category);

        System.out.println("Id_author:");
        int id_author = scanner.nextInt();
        scanner.nextLine();
        post.setId_author(id_author);

        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        post.setCreate_at(date);

        boolean check = true;
        String status = null;
        while (check) {

            System.out.println("Nhập status mới cho bài viết:");
            status = scanner.nextLine();
            if (status.equals(Status.DRAFT) | status.equals(Status.HIDDEN) | status.equals(Status.PUBLIC))
                check = false;
            else try {
                throw new CustomException("Dữ liệu không hợp lệ:");
            } catch (CustomException e) {
                e.printStackTrace();
            }
        }
        post.setStatus(status);
        return post;
    }

    public void updateStatus(){
        openConnect();
        System.out.println("Nhập id bài post bạn:");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean check = true;
        String status = null;
        while (check) {

            System.out.println("Nhập status mới cho bài viết:");
            status = scanner.nextLine();
            if (status.equals(Status.DRAFT) | status.equals(Status.HIDDEN) | status.equals(Status.PUBLIC))
                check = false;
            else try {
                throw new CustomException("Dữ liệu không hợp lệ:");
            } catch (CustomException e) {
                e.printStackTrace();
            }
        }
        String query = "UPDATE `post` SET `status`= '" + status + "' WHERE id = " + id;System.out.println(query);
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Update complete!");
    }

    public void delete() {
        boolean check = true;
        int id = 0;
        while (check) {
            System.out.println("Nhập id cần xóa:");
            id = scanner.nextInt();
            Post post = getPost(id);
            if (post == null) System.out.println("Id not found!");
            else check = false;
        }
        openConnect();

        String query = "DELETE FROM `post_tag` WHERE id_post=" + id;
        try {
            Statement stm = conn.createStatement();

            int row = stm.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        query = "DELETE FROM `post` WHERE id= " + id;
        try {
            Statement stm = conn.createStatement();

            int row = stm.executeUpdate(query);

            if (row != 0) {
                System.out.println("Xóa thành công: " + row);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
