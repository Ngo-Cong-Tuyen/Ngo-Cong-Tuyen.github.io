import java.util.Scanner;
import java.lang.Math;
public class Caculation {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println( "Nhap gia tri cua a:");
        double a= scanner.nextDouble();
        System.out.println("Nhap gia tri cua b:");
        double b= scanner.nextDouble();
        System.out.println("Tong a+b la:");
        System.out.println(Sum(a, b));
        System.out.println("Hieu a+b la:");
        System.out.println(Sub(a, b));
        System.out.println("Tich a+b la:");
        System.out.println(Times(a, b));
        System.out.println("Thuong a+b la:");
        System.out.println(Div(a, b));
    }

    public static double Sum(double a, double b) {
       return a+b;
    }

    public static double Sub(double a, double b) {
        return a-b;
    }

    public static double Times(double a, double b) {
        return a*b;
    }

    public static double Div(double a, double b) {
        return a/b;
    }

    public static  double CtoF(double t){
        return t * 1.8+32;
    }

    public static double FtoC(double t){
        return (t-32)/1.8;
    }

    public static double Pythagore(double a, double b){
        double c= Math.sqrt((a*a+b*b));
        return c;
    }

    public static double BMI(double weight, double height){
        return (weight/(height*height));
    }
}
