package leetcode.offer;

/**
 * 二叉树的镜像
 *
 * @author yx
 * @create 2019-05-04  10:30
 **/
public class Q18 {
    public void Mirror(TreeNode root) {
        if(root==null) return;
        TreeNode right = root.right;
        root.right = root.left;
        root.left = right;
        Mirror(root.right);
        Mirror(root.left);
    }
}
