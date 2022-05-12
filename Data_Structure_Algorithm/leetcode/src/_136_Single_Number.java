import java.util.HashMap;
import java.util.HashSet;

public class _136_Single_Number {
    public static void main(String[] args) {
        int[] nums ={4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
//    public static int singleNumber(int[] nums) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int i: nums) {
//            if (!set.add(i)){
//                set.remove(i);
//            }
//        }
//        int rs=0;
//        for (int i: set) rs=i;
//        return rs;
//    }

//    public static int singleNumber(int[] nums) {
//        HashMap<Integer, Boolean> map = new HashMap<>();
//        for (int i: nums) {
//            if (!map.containsKey(i)) map.put(i,true);
//            else map.put(i,false);
//        }
//        int rs=0;
//        for (Integer k: map.keySet()){
//            if (map.get(k)) rs=k;
//        }
//        return rs;
//    }

    public static int singleNumber(int[] nums) {
        int length=nums.length;
        int result=0;
        for(int x=0;x<length;x++){
            System.out.print(result+ " " + nums[x]);
            result=result^nums[x];
            System.out.println(" "+result);
        }
        return result;
    }
}
