import java.util.Arrays;

public class _283_Move_Zeroes {
    public static void main(String[] args) {
        int[] nums= {2,1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

//    public static void moveZeroes(int[] nums) {
//        int[] arr= new int[nums.length];
//        int j=0;
//        for (int i=0; i< nums.length;i++){
//            if (nums[i]!=0) {
//                arr[j]= nums[i];
//                j++;
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            nums[i]=arr[i];
//        }
//    }

    public static void moveZeroes(int[] nums) {
        int i=1;
        int j=0;
        while (i< nums.length){
            while ( j< nums.length && nums[j]!=0){
                j++;
            }
            j=j--;
            if(i<j) i=j+1;
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
        }
    }
}
