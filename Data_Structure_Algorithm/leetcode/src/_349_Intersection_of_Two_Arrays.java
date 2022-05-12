import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class _349_Intersection_of_Two_Arrays {
    public static void main(String[] args) {
        int[] num1 = {4, 9, 5};
        int[] num2 = {9, 4, 9, 8, 4};
        int[] arr = intersection(num1, num2);
        System.out.println(Arrays.toString(arr));
    }

//    public static int[] intersection(int[] nums1, int[] nums2) {
//        HashSet<Integer> arr1 = new HashSet<Integer>();
//        HashSet<Integer> arr2 = new HashSet<Integer>();
//
//        for(int i: nums1){
//            arr1.add(i);
//        }
//
//        for(int i: nums2){
//            arr2.add(i);
//        }
//        int n = Math.min(nums1.length, nums2.length);
//        int[] arr= new int[n];
//        int j=0;
//        for (int i: arr1){
//            if (arr2.contains(i)) {
//                arr[j]=i;
//                j++;
//            }
//        }
//        arr1.retainAll(arr2);
//        int [] arr= new int[arr1.size()];
//
//        for (int i=0; i<){
//
//        }
//        return arr;
//
//    }
//    public static int[] intersection(int[] nums1, int[] nums2) {
//        int[] arr= new int[1000];
//        for(int i: nums1){
//                if (arr[i]==0) arr[i]++;
//        }
//        int n=0;
//        for(int i: nums2){
//                if (arr[i]==1) {
//                    arr[i]++;
//                    n++;
//                }
//        }
//        int[] value= new int[n];
//        int j=0;
//        for (int i=0;i<arr.length;i++){
//            if (arr[i]==2){
//                value[j]=i;
//                j++;
//            }
//        }
//        return value;
//    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, 1);
        }

        int n=0;
        for (int i : nums2) {
            if (map.containsKey(i)) {
                if (map.get(i)==1){
                    map.put(i, 2);
                    n++;
                }

            }
        }

        int[] result = new int[n];
        int j = 0;
        for (int i : map.keySet()) {
            if (map.get(i)==2) {
                result[j] = i;
                j++;
            }
        }
        return result;
    }
}
