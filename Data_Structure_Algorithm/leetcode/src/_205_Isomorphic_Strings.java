import java.util.HashMap;

public class _205_Isomorphic_Strings {
    public static void main(String[] args) {
        String s= "badc";
        String t= "baba";
        System.out.println(isIsomorphic(s,t));
    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i=0; i< s.length(); i++){
            Character cs = s.charAt(i);
            Character ct = t.charAt(i);
            if (!map.containsKey(cs)) {
                System.out.println(cs + " "+ ct);
                if (map.containsValue(ct)) return false;
                map.put(cs,ct);
            } else if ( map.get(cs)!= ct) return false;
            System.out.println(map);
        }
        return true;
    }
}
