public class Main {
    public static void main(String[] args) {
//        MyBinaryTree binaryTree = new MyBinaryTree();
//        binaryTree.init();


        TreeNode n8 = new TreeNode(8);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n12 = new TreeNode(12);
        TreeNode n9 = new TreeNode(9);
        TreeNode n15 = new TreeNode(15);
        TreeNode n14 = new TreeNode(14);
        TreeNode n11 = new TreeNode(11);
        TreeNode n10 = new TreeNode(10);
        TreeNode n5 = new TreeNode(5);

        System.out.println("BST");
        n8.left = n6;
        n8.right = n12;

        n6.right = n7;

        n12.left = n9;
        n12.right = n15;

        n9.right = n11;
        n11.left = n10;

        n15.left = n14;
        n6.left = n5;

        MyBinarySearchTree bst = new MyBinarySearchTree();
//        bst.insert(n8, 10);
//        System.out.println("Done");
//
//        bst.remove(n8, 11);
//        System.out.println("Done");

        bst.preOder(n8);
    }
}
