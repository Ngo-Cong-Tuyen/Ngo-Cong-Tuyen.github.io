import java.util.Scanner;
import java.util.regex.Pattern;

public class Exercise_6 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập email:");
        String email= scanner.nextLine();
        System.out.println("Nhập số điện thoại");
        String phoneNumber= scanner.nextLine();
        String EMAIL_PATTERN = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        if (Pattern.matches(EMAIL_PATTERN,email)) {
            System.out.println("Email hợp lệ.");
        } else {
            System.out.println("Email không hợp lệ.");
        }
        boolean check=true;
        if (phoneNumber.length()>=9 && phoneNumber.length()<=11) {
            for (int i=0; i<phoneNumber.length();i++) {
                if (phoneNumber.charAt(i)<48 || phoneNumber.charAt(i)>57) {
                    check=false;
                }
            }
        } else check=false;
        if (check) {
            System.out.println("Số điện thoại hợp lệ.");
        } else {
            System.out.println("Số điện thoại không hợp lệ.");
        }
    }
}
