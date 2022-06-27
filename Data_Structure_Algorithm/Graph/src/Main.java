public class Main {
    public static <MyMutableInt> void main(String[] args) {
        MyMutableInt count = new MyMutableInt(2);
        for (int i=1; i<10;i++){
            go(count);
        }
        System.out.println(count);
    }

    public static void go(int count){
        count=count+1;
    }
}
