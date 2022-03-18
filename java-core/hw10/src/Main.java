import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        try{
            System.out.println("Nhap tuoi:");
            int age=sc.nextInt();
            if(age<=0) throw new ArithmeticException("Tuoi ko dc am");
//        }  catch (Exception e) {
//            System.out.println("Ko hop le");
//        }
    }

}
