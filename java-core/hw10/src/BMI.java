import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try {
            System.out.println("Nhập chiều cao:");
            double height= Double.parseDouble(sc.nextLine());
            if (height<=0) throw new MyException("Chieu cao nho hon 0");
            System.out.println("Nhập cân nặng:");
            double weight=Double.parseDouble(sc.nextLine());
            if (weight<=0) throw new MyException("Can nang nho hon 0");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e1) {
            System.out.println("Ban dang nhap sai kieu du lieu");
        }
    }
}
