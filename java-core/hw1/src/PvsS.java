import java.util.Scanner;
import java.lang.Math;

public class PvsS {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Ban kinh hinh tron la:");
        double r= scanner.nextDouble();
        System.out.println("chu vi hinh tron la: "+ Math.round(Math.PI*2*r*100.0) /100.0);
        System.out.println("Dien tich hinh tron la: "+ Math.round(Math.PI*r*r*100.0)/100.0);
    }
}
