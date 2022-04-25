public class _1089_Duplicate_Zeros {
    public static void duplicateZeros(int[] arr) {
        int j=0;
        int i=0;
        while (j< arr.length){
            if (arr[i]!=0) j++; else j=j+2;
            i++;
        }
        j--;
        i--;
        if (j>= arr.length) {
            j--;
            arr[j]= arr[i];
            i--;
            j--;
        }
        while (j>0){
            if (arr[i]==0) {
                arr[j]=arr[i];
                j--;
            }
            arr[j]=arr[i];
            i--;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {8,4,5,0,0,0,0,7};
        duplicateZeros(arr);
        for(int i:arr) {
            System.out.println(i);
        }
    }
}
