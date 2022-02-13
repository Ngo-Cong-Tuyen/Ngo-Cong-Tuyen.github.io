import java.util.Scanner;
public class Pythagore {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Nhap 2 canh goc vuong:");
        double a= scanner.nextDouble();
        double b= scanner.nextDouble();
        System.out.println("Canh huyen tam giac vuong la:");
        System.out.println(Caculation.Pythagore(a,b));

    }

}
