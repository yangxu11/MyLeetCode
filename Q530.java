package leetcode;

/**
 * 二叉搜索树的最小绝对差
 *
 * @author yx
 * @create 2019-06-08  21:17
 **/
public class Q530 {
    //中序遍历
    int res = Integer.MAX_VALUE;
    int pre = -1;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root){
        if(root==null) return;

        dfs(root.left);
        if(pre<0){
            pre = root.val;
        } else{
            res = Math.min(res,Math.abs(root.val-pre));
            pre = root.val;
        }
        dfs(root.right);
    }
}
