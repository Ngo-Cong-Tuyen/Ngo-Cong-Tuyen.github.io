import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Scanner sc = new Scanner(System.in);
        BlogManager blogManager = new BlogManager();
        boolean check= true;
        while (check) {
            System.out.println("Menu lựa chọn:\n" +
                    "1.In ra toàn bộ post.\n" +
                    "2.In ra các post có status = public.\n" +
                    "3.Thêm bài post mới.\n" +
                    "4.Cập nhật status cho post.\n" +
                    "5.Xóa bài post.\n" +
                    "0.Exit.");

            System.out.println("Bạn muốn lựa chọn:");
            byte n = sc.nextByte();
            switch (n) {
                case 1:
                    String query = "SELECT * FROM `post`";
                    blogManager.getBlog(query);
                    break;
                case 2:
                    System.out.println("Các post có status bằng public");
                    query = "SELECT * FROM `post` WHERE status LIKE '%public%'";
                    blogManager.getBlog(query);
                    break;
                case 3:
                    blogManager.insertNewPost();
                    break;
                case 4:
                    blogManager.updateStatus();
                    break;
                case 5:
                    blogManager.delete();
                    break;
                case 0:
                    System.out.println("Exit!");
                    check=false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
