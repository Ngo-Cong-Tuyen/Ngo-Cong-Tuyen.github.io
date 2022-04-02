import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        User user = manager.Login();
        menu(user);
    }

    public static void menu(User user){
        Manager manager = new Manager();
        boolean check = true;
        while (check) {
            System.out.println("Bạn muốn thực hiện: \n" +
                    "1.Truy vấn số dư tài khoản \n" +
                    "2.Chuyển tiền.\n" +
                    "3.Xem lịch sử giao dịch \n" +
                    "0.Exit");

            System.out.println("Chọn chức năng từ 1 đến 3:");
            Scanner sc = new Scanner(System.in);
            byte n = sc.nextByte();
            switch (n) {
                case 1:
                    System.out.println("Số dư tài khoản của bạn là: " + user.getBalance());
                    break;
                case 2:
                    manager.Transition(user);
                    break;
                case 3:
                    manager.getTransactionHistory(user);
                    break;
                case 0:
                    check =false;
                    break;
                default:
                    System.out.println("Không hợp lệ! Xin vi lòng nhập lại:");
            }
        }
    }
}
