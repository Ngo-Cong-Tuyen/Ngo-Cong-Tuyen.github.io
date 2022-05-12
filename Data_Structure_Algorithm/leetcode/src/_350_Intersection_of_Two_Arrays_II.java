import java.util.Arrays;
import java.util.HashMap;

public class _350_Intersection_of_Two_Arrays_II {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] rs = intersect(nums1, nums2);
        System.out.println(Arrays.toString(rs));

    }
    // Làm theo Hashmap.
    /*
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hashMap1 = new HashMap<>();
        HashMap<Integer,Integer> hashMap2 = new HashMap<>();

        for (int i : nums1) {
            if (hashMap1.containsKey(i)) {
                int n = hashMap1.get(i)+1;
                hashMap1.put(i,n);
            } else hashMap1.put(i,1);
        }

        for (int i : nums2) {
            if (hashMap2.containsKey(i)) {
                int n = hashMap2.get(i)+1;
                hashMap2.put(i,n);
            } else hashMap2.put(i,1);
        }
        int count=0;
        for (int i: hashMap1.keySet()) {
            if (hashMap1.containsKey(i) && hashMap2.containsKey(i)) {
                count= count+ Math.min(hashMap1.get(i), hashMap2.get(i));
            }
        }

        int[] rs = new int[count];
        int j=0;
        for (int i: hashMap1.keySet()) {
            if (hashMap1.containsKey(i) && hashMap2.containsKey(i)) {
                int n= Math.min(hashMap1.get(i), hashMap2.get(i));
                while (n>0){
                    rs[j]= i;
                    j++;
                    n--;
                }
            }
        }

//        System.out.println(hashMap1);
//        System.out.println(hashMap2);
        return rs;
    }
    */

    // Làm theo thuật toán.
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] table = new int[1001];

        for(int n: nums1)
            table[n]++;
        int point = 0;
        for(int n: nums2){
            if(table[n] >0){
                nums1[point++] = n;
                table[n]--;
            }

        }

        return Arrays.copyOf(nums1, point);
    }
}
