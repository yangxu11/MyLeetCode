package leetcode;
//路径总和，
public class Q112 {
    //使用减法可以减少变量
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;

        sum -= root.val;
        if(root.left==null && root.right==null && sum==0) {
            return true;
        }
        return hasPathSum(root.left,sum)||hasPathSum(root.right,sum);

    }
}
