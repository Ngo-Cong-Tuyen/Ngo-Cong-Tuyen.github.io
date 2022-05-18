package Tree;

public class _104_Maximum_Depth_of_Binary_Tree {
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

        System.out.println(maxDepth(n3));
    }

    public static int maxDepth(TreeNode root) {
        if (root== null) return 0;
        if (root.left==null && root.right==null) {
            return 1;
        } else if (root.left == null) {
            return maxDepth(root.right)+1;
        } else if (root.right == null) {
            return maxDepth(root.left)+1;
        } else {
            int l = maxDepth(root.left);
            int r = maxDepth(root.right);
            return Math.max(l,r)+1;
        }
    }
}
