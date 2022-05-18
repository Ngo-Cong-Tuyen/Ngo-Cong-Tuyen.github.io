package Tree;

import java.util.ArrayList;

public class _173_Binary_Search_Tree_Iterator {
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

        BSTIterator bstIterator = new BSTIterator(n3);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(bstIterator.list);
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
    }
}
