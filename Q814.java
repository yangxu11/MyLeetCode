package leetcode;
//二叉树剪枝
public class Q814 {
    public TreeNode pruneTree(TreeNode root) {
        if(root==null) return root;


        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(contains_1(root)) {
            return root;
        } else{
            return null;
        }

    }
    public boolean contains_1(TreeNode root) {
        if(root==null) return false;
        if(root.val == 1) {
            return true;
        } else {
            return contains_1(root.left)||contains_1(root.right);
        }
    }
}
