package leetcode;

/**
 * 二叉树的最大深度
 *
 * @author yx
 * @create 2019-03-27  20:07
 **/
public class Q104 {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
