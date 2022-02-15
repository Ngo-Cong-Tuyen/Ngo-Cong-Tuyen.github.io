import java.util.Scanner;

public class Str {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Nhập chuỗi 1:");
        String str1=scanner.nextLine();
        System.out.println("Nhập chuỗi 2:");
        String str2=scanner.nextLine();
        boolean i = str1.equals(str2);
        String s= (i == true) ? "Hai chuỗi giống nhau": "Hai chuỗi khác nhau";
        System.out.println(s);
        if (str1.length() == str2.length()) {
            System.out.println("Hai chuỗi có độ dài giống nhau");
        } else {
            System.out.println("Hai chuỗi có độ dài khác nhau");
        }
        s = str1.contains(str2)==true ? "Chuỗi 1 chứa chuỗi 2": "Chuỗi 1 không chứa chuỗi 2";
        System.out.println(s);

    }
}
