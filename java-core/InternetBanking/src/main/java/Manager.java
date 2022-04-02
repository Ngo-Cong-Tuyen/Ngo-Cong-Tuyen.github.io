import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager {
    Scanner scanner = new Scanner(System.in);

    ConnectDatabase connectDatabase = new ConnectDatabase();
    Connection conn;

    public void openConnect(){
        conn = connectDatabase.connect();
    }

    public User getUser(String column, String value) {
        User user = new User();
        openConnect();

        try {
            String query = "SELECT * FROM `user` u  WHERE " + column+ "=" + value;

            Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet result = stm.executeQuery(query);

            while (result.next()) {
                user.setId(result.getInt("id"));
                user.setPassword(result.getString("pass_word"));
                user.setPhoneNumber(result.getString("phoneNumber"));
                user.setAccount(result.getString("account"));
                user.setBalance(result.getLong("balance"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User Login() {

        User user =new User();
        boolean check = true;
        while (check) {
            try {
                System.out.println("Nhập số điện thoại của bạn:");
                String yourPhoneNumber = scanner.nextLine();
                user = getUser("phoneNUmber", yourPhoneNumber);
                if (user.getPhoneNumber() == null) throw new CustomException("Số điện thoại không hợp lệ:"); else check= false;
            } catch (CustomException e) {
                e.printStackTrace();
                System.out.println("Xin vui lòng nhập lại!");
            }
        }

        boolean isContinue = true;
        while (isContinue) {
            try {
                System.out.println("Nhập password của bạn:");
                String yourPassword = scanner.nextLine();
                if (!yourPassword.equals(user.getPassword())) throw new CustomException("Mật khẩu sai!");
                else isContinue = false;
            } catch (CustomException e) {
                e.printStackTrace();
                System.out.println("Xin vui lòng nhập lại!");
            }
        }

        System.out.println("Đăng nhập thành công!");
        return user;
    }

    public void Transition(User user){
        TransitionHistory tranHis = new TransitionHistory();
        User recipient =new User();
        boolean check = true;
        while (check) {
            try {
                System.out.println("Nhập số tài khoản của người nhận:");
                String account = scanner.nextLine();
                recipient = getUser("account", account);
                if (recipient.getAccount().equals(user.getAccount())) throw new CustomException("Bạn không thể chuyển đến số tài khoản này!");
                if (recipient.getAccount() == null) throw new CustomException("Số tài khoản người nhận không tồn tại!"); else check= false;
            } catch (CustomException e) {
                e.printStackTrace();
                System.out.println("Xin vui lòng nhập lại!");
            }
        }
        int money =0;
        check = true;
        while (check) {
            try {
                System.out.println("Nhập số tiền bạn muốn gửi:");
                money = scanner.nextInt();
                if (money <=0 | money > (user.getBalance()-50000)) throw new CustomException("Số tiền nhập không hợp lệ!"); else check = false;
            } catch (CustomException e) {
                e.printStackTrace();
                System.out.println("Xin vui lòng nhập lại!");
            } catch (InputMismatchException e1) {
                System.out.println("Bạn nhập không hợp lệ!");
                scanner.nextLine();
            }
        }

        String query = "UPDATE  `user` SET balance = balance -" + money + " WHERE id = " + user.getId();
        updateAccount(query);
        query = "UPDATE  `user` SET balance = balance +" + money + " WHERE id = " + recipient.getId();
        updateAccount(query);

        tranHis.setId_user(user.getId());

        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        tranHis.setDate_transition(date);

        tranHis.setAccount(recipient.getAccount());
        tranHis.setMoney(money);
        scanner.nextLine();
        System.out.println("Nội dung chuyển tiền:");
        String content = scanner.nextLine();
        tranHis.setContent(content);

        updateTransactionHistory(tranHis);

        System.out.println("Chuyển tiền thành công!");
    }

    public void updateAccount(String query) {
        openConnect();
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTransactionHistory(TransitionHistory tranHis) {
        openConnect();
        String query = "INSERT INTO `transactionHistory`(`id`, `id_user`, `date_transaction`, `account`, `money`, `content`)\n" +
                "VALUES (null,?,?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1,tranHis.getId_user());
            pstm.setDate(2,tranHis.getDate_transition());
            pstm.setString(3,tranHis.getAccount());
            pstm.setInt(4,tranHis.getMoney());
            pstm.setString(5,tranHis.getContent());

            int row = pstm.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getTransactionHistory(User user) {
        ArrayList<TransitionHistory> listTranHis = new ArrayList<>();

        openConnect();
        String query ="SELECT * FROM `transactionHistory` WHERE id_user = " + user.getId();

        try {
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(query);

            while (result.next()) {
                TransitionHistory tranHis = new TransitionHistory();
                tranHis.setId_user(result.getInt("id_user"));
                tranHis.setDate_transition(result.getDate("date_transaction"));
                tranHis.setAccount(result.getString("account"));
                tranHis.setMoney(result.getInt("money"));
                tranHis.setContent(result.getString("content"));

                listTranHis.add(tranHis);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        listTranHis.forEach(System.out::println);
    }
}
