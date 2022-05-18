package Tree;

public class _112_Path_Sum {
    public static void main(String[] args) {
        TreeNode n3= new TreeNode(3);
        TreeNode n9= new TreeNode(9);
        TreeNode n20= new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);

        n3.left = n9;
        n3.right = n20;
        n20.left = n15;
        n20.right = n7;
        System.out.println(hasPathSum(n3,12));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root== null) {
            return false;
        } else {
            if (root.val== targetSum && root.left== null && root.right== null) return true;
            targetSum = targetSum - root.val;
            if (hasPathSum(root.left, targetSum)) return true;
            if (hasPathSum(root.right, targetSum)) return true;
            return false;
        }
    }
}
