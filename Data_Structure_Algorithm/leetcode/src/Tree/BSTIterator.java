package Tree;

import java.util.ArrayList;

public class BSTIterator {
    TreeNode root;
    ArrayList<Integer> list= new ArrayList<>();
    int temp =0;

    public BSTIterator(TreeNode root) {
        this.root = root;
        getList(root);
    }


    public int next() {
        int n = list.get(temp);
        temp = temp+1;
        return n;
    }

    public boolean hasNext() {
        if (temp< list.size()) return true;
        else return false;
    }

    public Integer getList(TreeNode root) {
        if (root== null) return null;
        else {
            if (root.left == null && root.right== null) {
                list.add(root.val);
                return root.val;
            } else {
                getList(root.left);
                list.add(root.val);
                getList(root.right);
            }
        }
        return null;
    }
}
