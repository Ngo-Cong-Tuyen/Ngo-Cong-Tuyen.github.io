import java.util.Arrays;

public class _1051_Height_Checker {
    public static int heightChecker(int[] heights) {
        int [] check = heights.clone();

//        for (int i=0;i<heights.length-1;i++){
//            for (int j=i+1; j<heights.length;j++){
//                if (heights[i]>heights[j]) {
//                    int temps = heights[j];
//                    heights[j] = heights[i];
//                    heights[i] = temps;
//                }
//            }
//        }
        Arrays.sort(heights);
        System.out.println(Arrays.toString(heights));
        int count=0;
        for (int i=0; i< heights.length;i++) {
            if (check[i]!= heights[i]){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int [] heights = {1,1,4,2,1,3};
        System.out.println(heightChecker(heights));
    }
}
