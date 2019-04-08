package leetcode;

/**
 * 翻转二叉树
 *
 * @author yx
 * @create 2019-04-08  17:54
 **/
public class Q226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode node = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(node);
        return root;
    }
}
