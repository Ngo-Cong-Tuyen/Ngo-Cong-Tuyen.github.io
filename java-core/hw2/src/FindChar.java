

public class FindChar {
    public static void main(String[] args) {

        String s="Hello every one";
        int j=0;

        System.out.println("Index của e là:");
        for (int i=0; i< s.length(); i++){
            if (s.charAt(i) == 101) {
                System.out.println(i);
                j=j+1;
            }
        }
        System.out.println("Số lần suất hiện của e là: "+j);

    }
}
