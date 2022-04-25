public class _1662_Check_If_Two_String_Arrays_are_Equivalent {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1= new StringBuilder();
        for (String i: word1) {
            sb1.append(i);
        }
        StringBuilder sb2= new StringBuilder();
        for (String i: word2) {
            sb2.append(i);
        }
        return sb1.toString().equals(sb2.toString());
    }

    public static void main(String[] args) {
        String [] word1 =  {"ab", "c"};
        String [] word2 =  {"a", "bc"};
        System.out.println(arrayStringsAreEqual(word1,word2));
    }
}
