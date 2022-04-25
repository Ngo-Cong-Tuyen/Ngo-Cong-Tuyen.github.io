public class _414_Third_Maximum_Number {
    public static int thirdMax(int[] nums) {
        int a = nums[0];
        for (int i: nums) {
           if (a<i) a=i;
        }
        int b= a ;
        int i=0;
        while (i< nums.length) {
            if(nums[i]<a) {
                b=nums[i];
                for (int j=i+1; j< nums.length; j++) {
                    if(b<nums[j] && nums[j]<a) {
                        b=nums[j];
                    }
                }
                break;
            }
            i++;
        }
        int c= a ;
        i=0;
        while (i< nums.length) {
            if(nums[i]<b) {
                c=nums[i];
                for (int j=i+1; j< nums.length; j++) {
                    if(c<nums[j] && nums[j]<b) {
                        c=nums[j];
                    }
                }
                break;
            }
            i++;
        }

        return c;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,2,5,3,5};
        System.out.println(thirdMax(nums));
    }
}
