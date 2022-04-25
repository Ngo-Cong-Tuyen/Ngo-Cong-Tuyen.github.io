public class _48_Max_Consecutive_Ones {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int sum=0;
        for(int i=0;i< nums.length;i++){
            if (nums[i]==1 && i< nums.length){
                sum++;
            } else {
                if (max<sum) max=sum;
                System.out.println(sum);
                sum=0;
            }

        }
        if (max<sum) max=sum;
        return max;
    }

    public static void main(String[] args) {
        int [] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
