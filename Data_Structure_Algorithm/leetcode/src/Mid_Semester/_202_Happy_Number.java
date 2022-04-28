package Mid_Semester;

public class _202_Happy_Number {
    public static void main(String[] args) {
        System.out.println(isHappy(3));
    }

    public static boolean isHappy(int n) {
        int m=n;
        while (n!=1) {
            n=sumSquare(n);
            if (n==4) return false;
            System.out.println(n);
        }
        return true;
    }

    public static int sumSquare(int n) {
        int sum=0;
        while (n>0) {
            sum= sum+(n%10)*(n%10);
            n=n/10;
        }
        return sum;
    }
}
