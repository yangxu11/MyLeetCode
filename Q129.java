package leetcode;

/**
 * 求根到叶子节点数字之和
 *
 * @author yx
 * @create 2019-03-30  10:53
 **/
public class Q129 {
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;

        return getSum(root,0);
    }

    public int getSum(TreeNode root,int sum){

        int leftSum = 0,rightSum=0;
        if(root.left==null && root.right==null){
            return root.val+sum;
        }
        if(root.left!=null) {
            leftSum = getSum(root.left,10*(sum+root.val));
        }
        if(root.right!=null) {
            rightSum = getSum(root.right,10*(sum+root.val));
        }

        return leftSum+rightSum;
    }
}
