public class _13_Roman_to_Integer {
    public static void main(String[] args) {
        String s="III";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        int sum=0;
        int i=s.length()-1;
        while (i>=0) {
            switch (s.charAt(i)){
                case 'I':
                    if (sum>4) sum=sum-1; else sum=sum+1;
                    break;
                case 'V':
                    sum=sum+5;
                    break;
                case 'X':
                    if  (sum >40) sum=sum-10; else sum= sum+10;
                    break;
                case 'L':
                    sum=sum+50;
                    break;
                case 'C':
                    if  (sum >400) sum=sum-100; else sum= sum+100;
                    break;
                case 'D':
                    sum=sum+500;
                    break;
                case 'M':
                    sum=sum+1000;
                    break;

            }
            i--;
        }
        return sum;
    }
}
