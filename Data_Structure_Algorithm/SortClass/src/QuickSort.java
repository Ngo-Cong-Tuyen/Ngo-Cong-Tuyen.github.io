import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {7,3,2,16,24,4,11,9};
        quickSort(nums,0,7);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int iLeft, int iRight){
        if (iLeft>=iRight){
            return;
        }

        int iMid= (iLeft+iRight)/2;
        int key = nums[iMid];

        int pi= partition(nums,iLeft,iRight,key);


        quickSort(nums,iLeft,pi-1);
        quickSort(nums,pi,iRight);
    }

    public static int partition(int[] nums, int iLeft, int iRight, int key){
        int L= iLeft;
        int R = iRight;
        while (L <= R) {
            while (nums[L] < key){
                L++;
            }

            while (nums[R] > key){
                R--;
            }
            if(L<=R){
                int temp = nums[L];
                nums[L]=nums[R];
                nums[R]=temp;
                L++;
                R--;
            }


        }
        System.out.println("key:"+key);
        System.out.println(L);
        System.out.println(Arrays.toString(nums));
        return L;
    }
}
