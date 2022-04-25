public class _344_Reverse_String {
    public static void main(String[] args) {
        char[] s= {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(s);
    }
    public static void reverseString(char[] s) {
        int n= s.length -1;
        for (int i=0;i<n/2;i++){
            char tepms=s[i];
            s[i]=s[n-i];
            s[n-i]=tepms;
        }
    }
}
