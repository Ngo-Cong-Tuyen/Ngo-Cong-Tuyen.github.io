import java.util.HashMap;

public class _205_Isomorphic_Strings {
    public static void main(String[] args) {
        String s= "egg";
        String t= "add";
        System.out.println(isIsomorphic(s,t));
    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i=0; i< s.length(); i++){
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
                if (map.containsValue(t.charAt(i))) return false;
            } else {
                if (map.get(s.charAt(i))!= t.charAt(i)) return false;
            }
        }
        return true;
    }
}
