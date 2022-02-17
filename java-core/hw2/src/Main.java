import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhap so n:");
        int n= scanner.nextInt();
        int[]arr=new int[n];
        arr[0]=1;
        System.out.println(arr[0]);
        for (int i=2; i<=n; i++) {

            int j=0;
            int k=0;
            while (arr[j]!=0) {
                if (i % arr[j] == 0) {
                 k=k+1;
                }
                j=j+1;
            }
            if (k==1) {
                arr[j]=i;
                System.out.println(i);
            }
        }
    }
}