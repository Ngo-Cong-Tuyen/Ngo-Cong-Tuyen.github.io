import java.util.Arrays;

public class _26_Remove_Duplicates_from_Sorted_Array {
    public static int removeDuplicates(int[] nums) {
        int count= 0;
        for(int i=1; i< nums.length;i++){
            if (nums[count]!= nums[i]){
                count++;
                nums[count]= nums[i];
            }
        }
        return count+1;
    }

    public static void main(String[] args) {
        int [] nums ={1,1,2};
        int k = removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}
