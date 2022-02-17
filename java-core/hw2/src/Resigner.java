import java.util.Random;
import java.util.Scanner;

public class Resigner {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
//        String s1= "hkt";
//        String s2="123456";
//        System.out.println("Nhập username của bạn: ");
//        String username= scanner.nextLine();
//        System.out.println("Nhap password: ");
//        String password= scanner.nextLine();
//        if (username.equals(s1) && password.equals(s2)) {
//            System.out.println("Xin chao "+username);
//        } else if (username.equals(s1)==false){
//            if (password.equals(s2)) {
//                System.out.println("Ten khong ton tai");
//            } else {
//                System.out.println("quen mat khau");
//            }
//        } else {
//            System.out.println("Nhap sai password");
//        }
//       for (int i=1; i<=100; i++) {
//           if (i%3==0 && i%5==0) {
//               System.out.println(i+" chia het cho 3 vs 5");
//           } else {
//               if (i%3==0) {
//                   System.out.println(i+" chai het cho 3");
//               } else if (i%5==0){
//                   System.out.println(i+"chia het cho 5");
//               } else {
//                   System.out.println(i);
//               }
//           }
//       }

        Random rd= new Random();
        System.out.println("nhap 1 so bat ky: ");
        int i=scanner.nextInt();
        int j=0;
        while (i!=rd.nextInt(100)){
            j=j+1;

        }
        System.out.println("so lan random :" + j);

    }
}
