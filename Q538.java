package leetcode;

/**
 * 二叉搜索树转为累加树
 *
 * @author yx
 * @create 2019-06-09  19:36
 **/
public class Q538 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        getSum(root);
        return root;
    }
    public void getSum(TreeNode root){
        if(root==null) return ;

        getSum(root.right);
        sum += root.val;
        root.val = sum;
        getSum(root.left);
    }
}
