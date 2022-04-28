package Mid_Semester;

public class _724_Find_Pivot_Index {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int sum= 0;
        for (int n: nums) {
            sum= sum+n;
        }
        int leftSum=0;
        for (int i=0; i<nums.length; i++){
            leftSum=leftSum+nums[i];
            int rightSum= sum-leftSum+nums[i];
            if(leftSum==rightSum) return i;
        }
        return -1;
    }
}
