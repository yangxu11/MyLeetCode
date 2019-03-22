package leetcode;
//判断是否为平衡二叉树
public class Q110 {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;

        if(Math.abs(findDepth(root.left)-findDepth(root.right))<=1) {
            return isBalanced(root.left)&&isBalanced(root.right);
        } else {
            return false;
        }
    }

    public int findDepth(TreeNode root) {
        if(root == null) return 0;

        return Math.max(findDepth(root.left),findDepth(root.right))+1;
    }
}
