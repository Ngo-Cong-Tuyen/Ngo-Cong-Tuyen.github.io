package Final_Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _442_Find_All_Duplicates_in_an_Array {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i: nums) {
            if (!set.add(i)) {
                list.add(i);
            }
        }
        return list;
    }


}
