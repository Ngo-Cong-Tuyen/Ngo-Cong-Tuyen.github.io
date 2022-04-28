import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {7,3,2,16,24,4,11,9};
        int[] result = mergeSort(nums,0,7);
        System.out.println(Arrays.toString(result));
    }

    public static int[] mergeSort(int nums[], int iLeft,int iRight){
        int iMid = (iLeft+iRight)/2;
        if (iLeft==iRight) {
            int [] result= {nums[iMid]};
            System.out.println(Arrays.toString(result));
            return result;
        }

//        System.out.println(iLeft+ " "+ iMid+ " "+iRight);
        int[] arrLeft= mergeSort(nums,iLeft,iMid);
        int[] arrRight= mergeSort(nums,iMid+1,iRight);

        System.out.println(Arrays.toString(merge(arrLeft,arrRight)));
        return merge(arrLeft,arrRight);

    }

    public static int[] merge(int[] nums1, int [] nums2){
        int n=nums1.length+nums2.length;
        int[] result = new int[n];
        int i=0;
        int i1=0;
        int i2=0;
        while (i<n) {
            if (i1< nums1.length && i2 < nums2.length) {
                if (nums1[i1]<nums2[i2]){
                    result[i]=nums1[i1];
                    i1++;
                } else {
                    result[i]=nums2[i2];
                    i2++;
                }
                i++;
            } else if (i1<nums1.length) {
                result[i]=nums1[i1];
                i++;
                i1++;
            } else {
                result[i]=nums2[i2];
                i++;
                i2++;
            }
        }
        return result;
    }
}
