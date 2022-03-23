import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyGreneric<String> demo= new MyGreneric<>("Java");
        System.out.println(demo.getX());
        ArrayGreneric<String> arrayGreneric=new ArrayGreneric();
        
    }

    public static <T> void showlist(ArrayList<T> list) {
        for (T i : list) {
            System.out.println(i);
        }
    }


}


