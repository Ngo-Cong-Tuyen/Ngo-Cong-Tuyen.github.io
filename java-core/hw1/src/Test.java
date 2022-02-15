import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
//        System.out.println("nhap ba canh tam giac:");
//        double a= scanner.nextDouble();
//        double b= scanner.nextDouble();
//        double c= scanner.nextDouble();
//        String tg= a+b>c && a+c>b && b+c>a ?  "la tam giac" : "Ko phai la tam giac";
//        System.out.println(tg);
        Random random= new Random();
        int i= random.nextInt(100);
        System.out.print("Ramdom 1 số: ");
        System.out.println(i);
        String s= (i%2 ==0) ? i+ " là số chẵn" : i+" là số lẻ";
        System.out.println(s);
    }
}