import java.util.Scanner;

public class mangMotChieu {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập độ dài n của mảng:");
        int n= scanner.nextInt();
        int [] a=nhapMang(n);
        System.out.println("In mảng ra màn hình:");
        inMang(a);
        System.out.println("In ra mảng sau khi thay đổi:");
        plusArray(a);
        inMang(a);
    }

    public static int[] nhapMang(int n){
        Scanner scanner=new Scanner(System.in);
        int [] a= new int[n];
        System.out.println("Nhập n phần tử cho mảng");
        for (int i=0; i<n; i++){
            System.out.printf("a[%d]= ",i);
            a[i]= scanner.nextInt();
        }
        return a;
    }

    public static void inMang(int [] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void plusArray(int[] a){
        for (int i=0; i<a.length;i++){
            if(a[i]%2==0){
                a[i]=a[i]+1;
            }
        }
    }

}
