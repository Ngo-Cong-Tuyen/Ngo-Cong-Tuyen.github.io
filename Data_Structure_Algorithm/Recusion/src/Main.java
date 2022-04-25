public class Main {
    public static void main(String[] args) {
//        int result= factorial(5);
//        System.out.println(result);
//        result =factorial(5);
//        System.out.println(5);
//        for (int i=0;i<10;i++){
//            System.out.println(fibonacci(i));
//        }
//        towerHanoi(3,'A','B','C');

        for (int i=0;i<10;i++){
            System.out.println(fib(i));
        }
    }

    public static int factorial(int n){
        if (n>0) {
            return n * factorial(n-1);
        } else return 1;
    }

    public static int fibonacci(int n){
        if (n>1){
            return fibonacci(n-1)+fibonacci(n-2);
        } else if (n==1| n==0) {
            return n;
        } else return -1;
    }

    public static int fib(int n){
        int f0=0;
        int f1=1;
        int f2=1;
        if (n<2) {
            return n;
        } else {
            for (int i=2;i<n;i++){
                f0=f1;
                f1=f2;
                f2=f0+f1;
            }
            return f2;
        }
    }
    public static void towerHanoi(int n, char col1, char col2, char col3){
        if (n==1) {
            System.out.println("Chuyển đĩa 1 từ cột "+col1+" sang cột "+col3);
            return;
        } else {
            towerHanoi(n-1,col1,col3,col2);
            System.out.println("Chuyển đĩa " + n + " từ cột "+col1+" sang cột "+col3);
            towerHanoi(n-1,col2,col1,col3);
        }

    }
}
