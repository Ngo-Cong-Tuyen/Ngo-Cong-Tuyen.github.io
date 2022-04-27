public class _7_Reverse_Integer {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }
    public static int reverse(int x) {
        int z=0;
        int y=0;
        while (x!=0) {
            z=y;
            y=y *10+ x % 10;
            if (Math.abs(z) > Math.abs(y/10)) return 0;
            x=x/10;
            System.out.println(y);
        }
        return y;

    }
}
