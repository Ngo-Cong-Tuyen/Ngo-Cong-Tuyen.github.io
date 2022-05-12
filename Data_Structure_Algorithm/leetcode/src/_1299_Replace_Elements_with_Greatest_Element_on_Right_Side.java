import java.util.Arrays;

public class _1299_Replace_Elements_with_Greatest_Element_on_Right_Side {
    public static void main(String[] args) {
        int[] arr= {17,18,5,4,6,1};
        System.out.println(Arrays.toString(replaceElements(arr)));
    }

    public static int[] replaceElements(int[] arr) {
        int j=0;
        int max=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>= max) {
                max=arr[i];
                while (arr[j]< max && j>=1)  {
                    j--;
                    arr[j]=max;
                    System.out.println("da thuc hien");
                }

                j++;
                max=arr[i+1];
            }
        }
        return arr  ;
    }
}
