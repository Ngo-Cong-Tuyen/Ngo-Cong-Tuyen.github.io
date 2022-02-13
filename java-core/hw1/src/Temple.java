import java.util.Scanner;
public class Temple {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Ban muon chuyen doi tu do C sang do F true or flase?");
        boolean bl= scanner.nextBoolean();
        if (bl==true) {
            System.out.println("Nhap nhiet do C:");
            double t= scanner.nextDouble();
            System.out.println("Nhiet do F la:"+Caculation.CtoF(t));
        } else  {
            System.out.println("Nhap nhiet do F:");
            double t= scanner.nextDouble();
            System.out.println("Nhiet do C la:"+Caculation.FtoC(t));
        }


    }
}
