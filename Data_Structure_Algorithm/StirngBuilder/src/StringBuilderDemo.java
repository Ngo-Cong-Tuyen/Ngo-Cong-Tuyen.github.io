public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println(sb);
        sb.append(" world");
        System.out.println(sb);
        sb.insert(8,"adc");
        System.out.println(sb);
        sb.replace(0,5,"Xyz");
        System.out.println(sb);
    }
}
