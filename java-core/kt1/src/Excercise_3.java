import java.util.Random;

public class Excercise_3 {
    public static void main(String[] args) {
        Random rd= new Random();
        int n=rd.nextInt(100);
        System.out.println("Số random ra được là: "+n);
        if (isPrimeNumber(n)) {
            System.out.println("Số trên là số nguyên tố");
        } else {
            System.out.println("Số trên không phải số nguyên tố");
        }
    }

    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
