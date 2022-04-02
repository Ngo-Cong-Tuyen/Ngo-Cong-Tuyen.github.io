import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BlogManager blogManager = new BlogManager();
        String query = "SELECT * FROM `post`";
        blogManager.getBlog(query);
        System.out.println("Các post có status bằng public");
        query = "SELECT * FROM `post` WHERE status LIKE '%public%'";
        blogManager.getBlog(query);

//        Post post = blogManager.createNewPost();
//        blogManager.insertNewPost(post);

        System.out.println("Nhập id post bạn muốn tìm:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        query = "SELECT * FROM `post` WHERE id = "+ id;
        blogManager.getBlog(query);

//        System.out.println("Nhập id cần xóa:");
//        int id1= scanner.nextInt();
//        blogManager.delete(id1);
    }


}
