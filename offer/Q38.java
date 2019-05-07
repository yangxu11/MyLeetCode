package leetcode.offer;

/**
 * 二叉树的深度
 *
 * @author yx
 * @create 2019-05-07  18:01
 **/
public class Q38 {
    public int TreeDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;
    }
}
