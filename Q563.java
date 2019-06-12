package leetcode;

/**
 * 二叉树的坡度
 *
 * @author yx
 * @create 2019-06-12  21:07
 **/
public class Q563 {
    int res = 0 ;
    public int findTilt(TreeNode root) {
        dfs(root);
        return res;

    }

    private int dfs(TreeNode root){
        if(root==null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);

        res += Math.abs(left-right);
        return left+right+root.val;
    }
}
