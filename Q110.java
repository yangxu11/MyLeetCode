package leetcode;
//判断是否为平衡二叉树
public class Q110 {
    //最优解
    public boolean isBalanced1(TreeNode root) {
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left == -1 || right == -1 || Math.abs(left-right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }



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
