public class _941_Valid_Mountain_Array {
    public static void main(String[] args) {
        int[] arr= {3,5,5};
        System.out.println(validMountainArray(arr));
    }

    public static boolean validMountainArray(int[] arr) {
        int n=0;
        int i=1;
        while (i< arr.length-1){
            while(arr[i]>=arr[i-1]) i++;
            n++;
            if(i== arr.length-1) break;
            while (arr[i]<arr[i-1] && i< arr.length-1) i++;
            n++;
            if(i== arr.length-1) break;
        }
        if (n==2) return true; else return false;
    }
}
