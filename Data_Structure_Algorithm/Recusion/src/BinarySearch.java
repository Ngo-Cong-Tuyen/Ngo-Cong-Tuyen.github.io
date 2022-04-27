public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,9};
        binarySearch(numbers,7);
        System.out.println(binarySearch(numbers,7));
        System.out.println(search(numbers,7,0,8));
    }

    public static int binarySearch(int[] numbers, int key){
        int left =0;
        int right = numbers.length -1;

        while (left<=right) {
            int mid= (left+right)/2;
            if (key == numbers[mid]) {
                return mid;
            } else if (key < numbers[mid]) {
                right= mid-1;
            } else {
                left= mid+1;
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target, int left, int right) {

        if (left<right) {
            int mid = (left+right)/2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
                search(nums, target, left, right);
            } else {
                left = mid + 1;
                search(nums, target, left, right);
            }
        }

        return -1;
    }
}
