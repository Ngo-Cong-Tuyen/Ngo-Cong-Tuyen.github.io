import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập chuỗi để kiểm tra:");
        String s = scanner.nextLine();
        System.out.println(s.length());
        int j=0;
        for (int i=0; i< s.length(); i++) {
            int k=s.length()-1-i;
            if (s.charAt(i)==s.charAt(k)) {
                j=j+1;
            }
        }

        if (j==s.length()) {
            System.out.println("Chuỗi là chuỗi palindrome");
        } else {
            System.out.println("Chuỗi không phải là chuỗi palindrome");
        }
    }
}
