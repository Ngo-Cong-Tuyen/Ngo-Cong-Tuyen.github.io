import java.util.Random;
import java.util.Scanner;

public class Exercise_5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập số dòng cho mảng:");
        int n=scanner.nextInt();
        System.out.println("Nhập số cột cho mảng:");
        int m= scanner.nextInt();
        int [][] a=new int[n][m];
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++){
                System.out.print("a["+i+","+j+"]=");
                a[i][j]= scanner.nextInt();
            }
        }

        System.out.println("Mảng đã cho là:");
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("Các phần tử nằm trên đường chéo chính là:");
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++){
                if (i==j) {
                    System.out.print(a[i][j]+" ");
                }
            }
        }
        System.out.println();

        System.out.println("Tạo mảng mới là:");
        int [][] b = new int[n][m];
        Random rd=new Random();
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++){
                    b[i][j]= rd.nextInt(100);
                    System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("Mảng sau khi cộng là:");
        int t;
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++){
                t=a[i][j]+b[i][j];
                System.out.print(t+" ");
            }
            System.out.println();
        }
    }

//    public static int [][] taoMang(int n, int m){
//        int [][] a=new int[n][m];
//        Random rd=new Random();
//        for (int i=0;i<n;i++) {
//            for (int j=0;j<m;j++){
//                if (i==j) {
//                    a[i][j]= rd.nextInt(100);
//                }
//            }
//        }
//        return a;
//    }

}
