package Mid_Semester;

import java.util.Arrays;

public class _1512_Number_of_Good_Pairs {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        System.out.println(numIdenticalPairs(nums));
    }

    public static int numIdenticalPairs(int[] nums) {
        int[] arr = new int[101];
        for (int i: nums){
            arr[i]++;
        }
        int sum=0;
        for (int j: arr){
            int n=j-1;
            sum=sum+ (1+n)* n/2;
        }
        return sum;
    }
}
