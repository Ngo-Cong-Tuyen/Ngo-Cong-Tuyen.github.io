package Final_Test;

import java.util.*;

public class _841_Keys_and_Rooms {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        ArrayList<Integer>arrayList = new ArrayList<>();
        Collections.addAll(arrayList,1);
        rooms.add(arrayList);
        ArrayList<Integer>arrayList1 = new ArrayList<>();
        Collections.addAll(arrayList1,2);
        rooms.add(arrayList1);
        System.out.println(canVisitAllRooms(rooms));
        String s= "Tuyeền";
        s.substring(0,1);


    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        set.add(0);
        for (int i: rooms.get(0)){
            set.add(i);
            stack.add(i);
        }
        while (!stack.empty()){
            for (int i: rooms.get(stack.pop())){
                if (!set.contains(i)) {
                    stack.add(i);
                    set.add(i);
                }
            }
        }
        if (set.size() == rooms.size()) return true; else return false;
    }
}
