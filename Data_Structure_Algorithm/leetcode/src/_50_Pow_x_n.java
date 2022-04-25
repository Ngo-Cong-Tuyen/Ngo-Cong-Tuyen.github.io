public class _50_Pow_x_n {
    public static void main(String[] args) {
        System.out.println(myPow(2,-2147483648));
    }
//    public static double myPow(double x, int n) {
//        return Math.pow(x,n);
//    }

    public static double myPow(double x, int n) {
        if (n<0) {
            x=1/x;
            n=-n;
        }
        if (n==0) {
            return 1.0;
        } else if (n % 2 ==0) {
            double half = myPow(x,n/2);
            return half*half;
        } else {
            double half = myPow(x,n/2);
            return half * half * x;
        }
    }
}
