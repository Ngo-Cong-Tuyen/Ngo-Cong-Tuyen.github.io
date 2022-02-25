public class Exercise_2 {
    public static void main(String[] args) {
        String s="You only live once, but if you do it right, once is enough";
        System.out.println("Chuỗi đã cho: "+s);
        s=s.trim();
        int k=0;
        int h=0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==32) {
                k=k+1;
            }
            if (s.charAt(i)==111) {
                h=h+1;
            }
        }
        k=k+1;
        System.out.println("Số từ trong chuỗi là: "+ k);
        System.out.println("Số ký tự o trong chuỗi là: "+ h);
        System.out.println("Index lần lượt là:");
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i)==111) {
                System.out.println(i);
            }
        }
    }
}
