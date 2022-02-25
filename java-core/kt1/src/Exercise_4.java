public class Exercise_4 {
    public static void main(String[] args) {
        System.out.println("10 số nguyên tố đầu tiên là:");
        int i=0;
        int n=2;
        while (i<10) {
            if (isPrimeNumber(n)) {
                System.out.println(n);
                i=i+1;
            }
            n=n+1;
        }
        System.out.println("Các số nguyên tố nhỏ hơn 10 là: ");
        n=2;
        while (n<10) {
            if (isPrimeNumber(n)) {
                System.out.println(n);
            }
            n=n+1;
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
