import java.util.Arrays;

public class _27_Remove_Element {
    public static int removeElement(int[] nums, int val) {
        int count =0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!= val) {
                nums[count]=nums[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int k = removeElement(nums,3);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}
